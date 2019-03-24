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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.dao.UserInfoDAO;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.UserRole;
import com.ecommerce.entity.Users;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserInfo;
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
	public ModelAndView welcomePage( @ModelAttribute("user") UserInfo user, @ModelAttribute("regError") String regError,@ModelAttribute("regSuccess") String regSuccess) {
		System.out.println("entered /index ");
		ModelAndView mav = new ModelAndView("index");

		if(user==null) {
			user = new UserInfo();
		}
		List<Products> productList=productDAO.findAllProducts();
		List<ProductInfo> productinfoList = new ArrayList<ProductInfo>();;
		ProductInfo productInfo=null;
		for (Products products : productList) {
			productInfo= new ProductInfo();
			productInfo.setProductCodeSku(products.getProductCodeSku());
			productInfo.setProductDescription(products.getProductDescription());
			productInfo.setProductName(products.getProductName());
			productInfo.setUnitPrice(products.getUnitPrice());
			productInfo.setImageUrl(getImageForProduct(products.getDestFilePath()));
			productinfoList.add(productInfo);
		}
		System.out.println("User "+user.getFirstName());
		mav.addObject("productinfoList",productinfoList);
		mav.addObject("user",user);
		System.out.println("regerror "+regError);
		mav.addObject("regError", regError);
		System.out.println("regSuccess "+regSuccess);
		mav.addObject("regSuccess", regSuccess);
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
	public String productDetailsPage(Model model, Principal principal) {
		System.out.println("in product details action");

		return "product-details";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartPage(Model model, Principal principal) {
		System.out.println("in cart action");

		return "cart";
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopPage(Model model, Principal principal) {
		System.out.println("in shop action");

		return "shop";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkoutPage(Model model, Principal principal) {
		System.out.println("in checkout action");

		return "checkout";
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

		UserRole userrole = new UserRole();
		userrole.setRole_id(2);
		HashSet<UserRole> roleSet= new HashSet<UserRole>();
		roleSet.add(userrole);

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
		return mav;

	}

	// POST: Save product
	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	// Avoid UnexpectedRollbackException (See more explanations)
	/* @Transactional(propagation = Propagation.NEVER)*/
	public String productSave(Model model,
			@ModelAttribute("productForm")  @Validated ProductInfo productForm,
			BindingResult result 
			) {

		System.out.println("in /product post ");
		System.out.println(productForm.getProductName());
		System.out.println("no of uploaded files "+productForm.getFileData().size());
		// System.out.println(productInfo.getFileData().getOriginalFilename());
		if (result.hasErrors()) {
			System.out.println("Product has errors");
			return "product";
		}
		try {
			List<CommonsMultipartFile> files = productForm.getFileData();
			List<String> fileNames = new ArrayList<String>();
			File productImageDirectory= new File("E:/Product Images/"+productForm.getProductCodeSku());
			if(!productImageDirectory.exists()){
				productImageDirectory.mkdirs();
			}
			if (null != files && files.size() > 0)
			{
				for (CommonsMultipartFile multipartFile : files) {

					String fileName = multipartFile.getOriginalFilename();
					System.out.println("filename "+fileName);
					if(fileName !=null && fileName != "" ){
						fileNames.add(fileName);
						File imageFile = new File(productImageDirectory, fileName);
						try
						{
							multipartFile.transferTo(imageFile);
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
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


	private String getImageForProduct(String destFilePath) {
		File folder = new File(destFilePath);
		File[] listOfFiles = folder.listFiles();
		return listOfFiles[0].getName();
	}

}
