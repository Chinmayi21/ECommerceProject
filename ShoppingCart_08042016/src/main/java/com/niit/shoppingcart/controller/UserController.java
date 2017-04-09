package com.niit.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/Registration", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm(){
		ModelAndView mv = new ModelAndView("/Registration");
		mv.addObject("isUserClickedRegister", "true");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value = "/create_user", method= RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute(value="user") User user, BindingResult result, Model model){
		if(result.hasErrors()){
			return "Registration";
		}
		model.addAttribute("regSuccess","Registered Succesfully, login using username and password");
		model.addAttribute("userObject", user);
		userDAO.save(user);
		return "Login";
	}
}
	