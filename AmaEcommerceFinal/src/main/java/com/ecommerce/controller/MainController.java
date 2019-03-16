package com.ecommerce.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.UserInfoDAO;
import com.ecommerce.entity.UserRole;
import com.ecommerce.entity.Users;
import com.ecommerce.service.UserService;

@Controller
@Transactional
public class MainController {


	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	private UserService userService;


	@RequestMapping(value = {"/home" }, method = RequestMethod.GET)
	public String homePage() {
		System.out.println("entered /home ");
		return "homePage";
	}

	@RequestMapping(value = {"/" , "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("entered /index ");
		 ModelAndView mav = new ModelAndView("index");
		mav.addObject("user",new Users());
		 return mav;
	}


	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("user") Users user) {
		System.out.println("entered /login");
		
		ModelAndView mav = null;
		user = userService.validateUser(user);
	    
		 if (user !=null) {
			    mav = new ModelAndView("index");
			    mav.addObject("user", user);
			    } else {
			    mav = new ModelAndView("index");
			    mav.addObject("message", "Username or Password is wrong!!");
			    }
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
	  @ModelAttribute("user") Users user) {
	  //userService.register(user);
		System.out.println("first name "+user.getFirstName());
		user.setActive(1);
		
		UserRole userrole = new UserRole();
		userrole.setRole_id(2);
		HashSet<UserRole> roleSet= new HashSet<UserRole>();
		roleSet.add(userrole);
		
		user.setRoles(roleSet);
		//userServiceimpl.save(user);
		userService.save(user);
	  return new ModelAndView("index", "firstname", user.getFirstName());
	  }
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //yyyy-MM-dd'T'HH:mm:ssZ example
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


}
