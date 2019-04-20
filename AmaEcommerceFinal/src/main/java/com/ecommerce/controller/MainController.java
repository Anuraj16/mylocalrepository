package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ecommerce.Utils.AmazonUtils;
import com.ecommerce.Utils.Utils;
import com.ecommerce.dao.UserInfoDAO;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.UserRole;
import com.ecommerce.entity.Users;
import com.ecommerce.model.CartInfo;
import com.ecommerce.model.CartLineInfo;
import com.ecommerce.model.OrderDetailInfo;
import com.ecommerce.model.OrderInfo;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserInfo;
import com.ecommerce.service.OrderDAO;
import com.ecommerce.service.ProductDAO;
import com.ecommerce.service.UserService;
import com.ecommerce.validator.ProductInfoValidator;

@Controller
@Transactional
public class MainController {


	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private ProductInfoValidator productInfoValidator;

	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public String homePage() {
		System.out.println("entered /home ");
		return "homePage";
	}
	
	@RequestMapping(value = {"/login"})
	public ModelAndView loginPage(@ModelAttribute("user") UserInfo userInfo,RedirectAttributes ra ) {
		System.out.println("entered /login");
		ra.addFlashAttribute("showLogin", "Please login to continue");
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = {"/" , "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(HttpServletRequest request, @ModelAttribute("user") UserInfo user,Authentication auth, @ModelAttribute("regError") String regError,@ModelAttribute("regSuccess") String regSuccess,
			@ModelAttribute("addedToCart") String addedToCart	) {
		System.out.println("entered /index ");
		ModelAndView mav = new ModelAndView("index");
		boolean is_vendor=false;
		if(auth!=null){
			List<GrantedAuthority> grantList= (List<GrantedAuthority>) auth.getAuthorities();
			for (GrantedAuthority grantedAuthority : grantList) {
				if(grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_VENDOR")){
					is_vendor=true;
				}
			}
		}
		if(user==null) {
			user = new UserInfo();
		}
		List<Products> productList=null;
		if(is_vendor==true){
			productList=productDAO.findAllProductsForVendor(auth.getName());
		}else{
			productList=productDAO.findAllProducts();
		}
		
		List<ProductInfo> productinfoList = new ArrayList<ProductInfo>();;
		ProductInfo productInfo=null;
		for (Products products : productList) {
			productInfo= new ProductInfo();
			productInfo.setProductCodeSku(products.getProductCodeSku());
			productInfo.setProductDescription(products.getProductDescription());
			productInfo.setProductName(products.getProductName());
			productInfo.setUnitPrice(products.getUnitPrice());
			productInfo.setImageUrl(AmazonUtils.getImageForProduct(products));
			productinfoList.add(productInfo);
		}
		System.out.println("User "+user.getFirstName());
		mav.addObject("productinfoList",productinfoList);
		mav.addObject("user",user);
		System.out.println("regerror "+regError);
		mav.addObject("regError", regError);
		System.out.println("regSuccess "+regSuccess);
		mav.addObject("regSuccess", regSuccess);
		mav.addObject("addedToCart", addedToCart);
		mav.addObject("cartInfo", Utils.getCartInSession(request));
		return mav;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message", "Hi " + principal.getName()
			+ "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg",
					"You do not have permission to access this page!");
		}
		return "403Page";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFoundPage(Model model, Principal principal) {


		return "redirect:loginPage";
	}
	@RequestMapping(value = "/productDetails", method = RequestMethod.GET)
	public ModelAndView productDetailsPage(HttpServletRequest request,Model model, @RequestParam(value = "code") String code) {
		System.out.println("in product details action");
		ModelAndView mav = new ModelAndView("product-details");
		ProductInfo productInfo = null;

		System.out.println("in /product get "+code);
		if (code != null && code.length() > 0) {
			CartInfo cartInfo = Utils.getCartInSession(request);
			if(cartInfo.getCartLines().size()>0){
				for (CartLineInfo cartLineInfo : cartInfo.getCartLines()) {
					if(cartLineInfo.getProductInfo().getProductCodeSku().equalsIgnoreCase(code)){
						System.out.println("fetching product from req");
						productInfo=cartLineInfo.getProductInfo();
						productInfo.setQty(cartLineInfo.getQuantity()==0?1:cartLineInfo.getQuantity());
					}
				}
			}
			
			if(productInfo==null){
				System.out.println("fetching product from db");
				productInfo = productDAO.findProductInfo(code);
				if(productInfo.getQty()==0) {
					productInfo.setQty(1);
				}
			}
			System.out.println(productInfo.getProductName()+" desc "+productInfo.getProductDescription()+" file path "+productInfo.getDestFilePath());
			productInfo.setImageUrlList(AmazonUtils.getImageListForProduct(productInfo));
		}
		mav.addObject("user",new UserInfo());
		mav.addObject("productForm",productInfo);
		mav.addObject("cartInfo", Utils.getCartInSession(request));
		return mav;
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopPage(Model model, Principal principal) {
		System.out.println("in shop action");

		return "shop";
	}
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") UserInfo userInfo,RedirectAttributes ra ,  BindingResult result) {
		//userService.register(user);

		if(userInfo.getEmailId()==null || userInfo.getEmailId().isEmpty() || 
				userInfo.getFirstName()==null || userInfo.getFirstName().isEmpty() || 
				userInfo.getLastName()==null || userInfo.getLastName().isEmpty() ||
				userInfo.getPassword()==null || userInfo.getPassword().isEmpty()  ||
				userInfo.getUsername()==null || userInfo.getUsername().isEmpty() ) {
			System.out.println("sizew of checkbox array "+userInfo.getUserType().length);
			System.out.println("Mandatory fiel dis empty");
			ra.addFlashAttribute("regError", "Please fill all mandatory fields");
			return new ModelAndView("redirect:/index");
		}

		System.out.println("first name "+userInfo.getFirstName());
		Users user = new Users();
		user.setUsername(userInfo.getUsername());
		user.setFirstName(userInfo.getFirstName());
		user.setLastName(userInfo.getLastName());
		user.setPassword(userInfo.getPassword());
		user.setEmailId(userInfo.getEmailId());
		user.setPhone(userInfo.getPhone());
		user.setActive(1);

		HashSet<UserRole> roleSet= new HashSet<UserRole>();
		UserRole userrole = new UserRole();
		userrole.setRole_id(2);
		roleSet.add(userrole);
		if(userInfo.getUserType() != null && userInfo.getUserType().length != 0){
			System.out.println("usertype chkbx not null ");
			UserRole userrolev = new UserRole();
			if(userInfo.getUserType()[0].equalsIgnoreCase("Vendor")){
				System.out.println("new vendor created");
				userrolev.setRole_id(3);
				roleSet.add(userrolev);
			}
		}
		user.setRoles(roleSet);
		//userServiceimpl.save(user);
		userService.save(user);
		ra.addFlashAttribute("regSuccess", user.getUsername()+ " registered Successfully. Please login to continue");
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public ModelAndView product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
		ModelAndView mav = new ModelAndView("product");
		ProductInfo productInfo = null;

		System.out.println("in /product get ");
		if (code != null && code.length() > 0) {
			productInfo = productDAO.findProductInfo(code);
		}
		if (productInfo == null) {
			productInfo = new ProductInfo();
			productInfo.setNewProduct(true);
		}
		mav.addObject("productForm",productInfo);
		mav.addObject("user",new UserInfo());
		return mav;

	}

	// POST: Save product
	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	// Avoid UnexpectedRollbackException (See more explanations)
	/* @Transactional(propagation = Propagation.NEVER)*/
	public String productSave(Model model,
			@ModelAttribute("productForm")  @Validated ProductInfo productForm,
			BindingResult result ,Authentication authentication
			) {

		System.out.println("in /product post ");
		
		// System.out.println(productInfo.getFileData().getOriginalFilename());
		if (result.hasErrors()) {
			System.out.println("Product has errors");
			return "product";
		}
		try {
			List<CommonsMultipartFile> files = productForm.getFileData();
			//List<String> fileNames = new ArrayList<String>();
			File productImageDirectory= new File("E:/Product Images/"+productForm.getProductCodeSku());
			if(!productImageDirectory.exists()){
				productImageDirectory.mkdirs();
			}
			
			/*Amazon Aws Upload code*/
			
			
			
			String destFilePath=null;
			String fileNames="";
			if (null != files && files.size() > 0)
			{
				for (CommonsMultipartFile multipartFile : files) {

					File file = AmazonUtils.convertMultiPartToFile(multipartFile);
			        String fileName = AmazonUtils.generateFileName(multipartFile);
					System.out.println("amazon file "+file+" fileName "+fileName);
					fileNames+=fileName+",";					
					//String fileName = multipartFile.getOriginalFilename();
					System.out.println("filename "+fileName);
					if(file !=null && fileName !=null && fileName != "" ){
						/*code to upload files to local system start*/
					//	fileNames.add(fileName);
						/*File imageFile = new File(productImageDirectory, fileName);
						try
						{
							multipartFile.transferTo(imageFile);
						} catch (IOException e)
						{
							e.printStackTrace();
						}*/
						/*code to upload files to local system end*/
						try {
							AmazonS3 s3client= AmazonUtils.gets3Client();
							String bucketName=AmazonUtils.getBucketName();
							s3client.putObject(new PutObjectRequest(bucketName, productForm.getProductCodeSku()+"/"+fileName, file)
				            .withCannedAcl(CannedAccessControlList.PublicRead));
							destFilePath=AmazonUtils.endpointUrl+"/"+bucketName+"/"+productForm.getProductCodeSku();
							productForm.setDestFilePath(destFilePath);
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						
						/*code to upload images to amazon s3 bucket */
						
					}
				}
				System.out.println("fileNames "+fileNames.substring(0, fileNames.length()-1));
				productForm.setFileNames(fileNames.substring(0, fileNames.length()-1));
			}
			productForm.setVendorUserName(authentication.getName());
			productDAO.save(productForm);
		} catch (Exception e) {
			// Need: Propagation.NEVER?
			String message = e.getMessage();
			model.addAttribute("message", message);
			// Show product form.
			return "product";

		}
		return "redirect:/index";
	}
	@RequestMapping({ "/productList" })
	public ModelAndView listProductHandler(Model model) {
		ModelAndView mav = new ModelAndView("redirect:/index");

		// List<ProductInfo> productinfoList= productDAO.findAllProducts();
		/*  PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
                maxResult, maxNavigationPage, likeName);*/
		//	System.out.println("productinfoList size "+productinfoList.size());
		// mav.addObject("productinfoList", productinfoList);
		return mav;
	}

	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("code") String code) throws IOException {
		System.out.println("in /productImage get ");
		Products product = null;
		if (code != null) {
			product = this.productDAO.findProduct(code);
		}
		if (product != null && product.getDestFilePath() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			/*  TODO read the image from the destination file path and return*/
			// response.getOutputStream().write(product.getImage());
		}
		response.getOutputStream().close();
	}

	@RequestMapping({ "/addToCart" })
    public ModelAndView addToCart(HttpServletRequest request, Model model, //
    		@ModelAttribute("productForm") ProductInfo productForm,RedirectAttributes ra) {
		ModelAndView mav = new ModelAndView("redirect:/index");
		System.out.println(" in addToCart action "+productForm.getProductCodeSku()+" qty "+productForm.getQty());
		String code=productForm.getProductCodeSku();
        Products product = null;
       if (code != null && code.length() > 0) {
            product = productDAO.findProduct(code);
        }
        if (product != null) {
 
            // Cart info stored in Session.
            CartInfo cartInfo = Utils.getCartInSession(request);
 
            ProductInfo productInfo = new ProductInfo(product);
            productInfo.setImageUrl(AmazonUtils.getImageForProduct(product));
 
            cartInfo.addProduct(productInfo, productForm.getQty());
            Utils.setCartInSession(request, cartInfo);
        }
        // Redirect to shoppingCart page.
        ra.addFlashAttribute("user",new UserInfo());
        ra.addFlashAttribute("cartInfo", Utils.getCartInSession(request));
        ra.addFlashAttribute("addedToCart",product.getProductName()+" added to cart successfully");
        return mav ;
    }
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpServletRequest request,Model model) {
		System.out.println("in cart action");
		ModelAndView mav = new ModelAndView("cart");
		
		CartInfo cartInfo = Utils.getCartInSession(request);
		int subtotal=0;
		if(cartInfo.getCartLines().size()>0){
			for (CartLineInfo cartLineInfo : cartInfo.getCartLines()) {
				System.out.println("amount "+cartLineInfo.getAmount());
				subtotal +=(int) cartLineInfo.getAmount();
			}
			cartInfo.setSubTotal(subtotal);	
			Utils.setCartInSession(request, cartInfo);
			mav.addObject("cartInfo",cartInfo);
		}else{
			System.out.println("no items");
			mav.addObject("noItemsMsg", "Oops ! No items in the cart.");
		}
        System.out.println("size of cartlines "+cartInfo.getCartLines().size());
        mav.addObject("user",new UserInfo());
		return mav;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkoutPage(HttpServletRequest request,Model model) {
		System.out.println("in checkout action");
		ModelAndView mav = new ModelAndView("checkout");
		CartInfo cartInfo = Utils.getCartInSession(request);
		mav.addObject("cartInfo",cartInfo);
		mav.addObject("user",new UserInfo());
		return mav;
	}
	
	@RequestMapping(value = "/checkoutConfirmation", method = RequestMethod.POST)
	public ModelAndView checkoutAndSave(HttpServletRequest request,Model model,
			@ModelAttribute("customerInfo") CartInfo cartInfo) {
		if( cartInfo.getCustomerInfo().getFirstName() == null || cartInfo.getCustomerInfo().getFirstName().isEmpty() ||
				cartInfo.getCustomerInfo().getLastName() == null || cartInfo.getCustomerInfo().getLastName().isEmpty() ||	
				cartInfo.getCustomerInfo().getEmailId() == null || cartInfo.getCustomerInfo().getEmailId().isEmpty() ||
				cartInfo.getCustomerInfo().getAddress() == null || cartInfo.getCustomerInfo().getAddress().isEmpty() ||
				cartInfo.getCustomerInfo().getCity() == null || cartInfo.getCustomerInfo().getCity().isEmpty() ||
				cartInfo.getCustomerInfo().getPinCode()== null || cartInfo.getCustomerInfo().getPinCode().isEmpty() ||
				cartInfo.getCustomerInfo().getPhone() == null || cartInfo.getCustomerInfo().getPhone().isEmpty() ||
				cartInfo.getCustomerInfo().getCountry() == null || cartInfo.getCustomerInfo().getCountry().isEmpty() ) {
			ModelAndView mav = new ModelAndView("checkout");
			mav.addObject("cartInfo",cartInfo);
			mav.addObject("emptyError", "Please fill out all fields");
			return mav;
		}
		
		
		System.out.println("in checkout post action");
		ModelAndView mav = new ModelAndView("checkoutConfirmation");
		System.out.println(cartInfo.getCustomerInfo().getFirstName()+" lastname "+cartInfo.getCustomerInfo().getLastName());
		CartInfo cartInfo1 = Utils.getCartInSession(request);
		cartInfo1.setCustomerInfo(cartInfo.getCustomerInfo());
		mav.addObject("cartInfo",cartInfo1);
		mav.addObject("user",new UserInfo());
		return mav;
	}
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView placeOrder(HttpServletRequest request,Authentication authentication,Model model,
			@ModelAttribute("cartInfo") CartInfo cartInfo) {
		//CartInfo cartInfo1 = Utils.getCartInSession(request);
		System.out.println("in placeOrder action");
		ModelAndView mav = new ModelAndView("orderSuccess");
		cartInfo = Utils.getCartInSession(request);
			System.out.println("username from authentication "+authentication.getName());
			cartInfo.getCustomerInfo().setUsername(authentication.getName());
        if (cartInfo.isEmpty()) {
            // Redirect to shoppingCart page.
            //return "redirect:/shoppingCart";
        }/* else if (!cartInfo.isValidCustomer()) {
            // Enter customer info.
           // return "redirect:/shoppingCartCustomer";
        }*/
        try {
            orderDAO.saveOrder(cartInfo);
            mav.addObject("successOrderMsg", "Thank you for the order");
        } catch (Exception e) {
        	System.out.println("Some exception in placing order");
        	mav.addObject("failureOrderMsg", "Order Placement not successfull,Please try again");
        }
        // Remove Cart In Session.
        Utils.removeCartInSession(request);
         
        // Store Last ordered cart to Session.
        Utils.storeLastOrderedCartInSession(request, cartInfo);
 
        // Redirect to successful page.
        //return "redirect:/shoppingCartFinalize";
        return mav;
	}
	
	@RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
	public ModelAndView orderHistoryPage(HttpServletRequest request,Authentication authentication,Model model,RedirectAttributes ra) {
		System.out.println("in orderHistory action");
		ModelAndView mav = new ModelAndView("orderHistory");
		
		List<OrderInfo> orderInfoList=orderDAO.getAllOrders(authentication.getName());
		
		if(orderInfoList!=null && orderInfoList.size()<=0){
			ra.addFlashAttribute("NoOrders", "No orders history to display");
		}else{
			Products product=null;
			for (OrderInfo orderInfo : orderInfoList) {
				for (OrderDetailInfo detailInfo : orderInfo.getDetails()) {
					ProductInfo productInfo= productDAO.findProductInfo(detailInfo.getProductCode());
					product=new Products();
					product.setFileNames(productInfo.getFileNames());
					product.setDestFilePath(productInfo.getDestFilePath());
					detailInfo.setImageUrl(AmazonUtils.getImageForProduct(product));
				}
				
			}
		}
        System.out.println("size of orderInfoList "+orderInfoList.size());
        mav.addObject("orderInfoList", orderInfoList);
        mav.addObject("user",new UserInfo());
        mav.addObject("cartInfo", Utils.getCartInSession(request));
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //yyyy-MM-dd'T'HH:mm:ssZ example
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

		Object target = binder.getTarget();
		if (target == null) {
			return;
		}
		if (target.getClass() == ProductInfo.class) {
			// For upload Image.
			System.out.println("Product info binded");
			binder.setValidator(productInfoValidator);
			binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}
	
	@RequestMapping(value = "/cartSize", method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String getCartSize(HttpServletRequest request) {
		return ""+Utils.getCartInSession(request).getCartLines().size();
	}

}
