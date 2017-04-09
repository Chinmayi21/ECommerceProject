package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public ModelAndView showHome() {
		System.out.println("Starting the method showHome");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("msg", "Welcome to my cart");
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView showLogin() {
		System.out.println("Inside Login Page");
		ModelAndView mv = new ModelAndView("/Home"); // single page application
		mv.addObject("isUserClickedLogin", "true");
		return mv;
	}

	@RequestMapping("/Registration")
	public ModelAndView showRegistration() {
		System.out.println("Inside Registration Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedRegister", "true");
		return mv;
	}

	@RequestMapping("/validate")

	public ModelAndView validateCredentials(@RequestParam("userID") String id, @RequestParam("password") String pwd) {

		// get data from database

		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserLoggedIn", "false");
		if( userDAO.validate(id, pwd)==true)
		
		{
			//Credentials are correct
			mv.addObject("isUserLoggedIn", "true");
			
			user = userDAO.getUser(id);
			
			if(user.getRole().equals("role_admin"))
			{
				mv.addObject("isAdmin", "true");
			}
			else
			{
				mv.addObject("isAdmin", "false");
			}
			
			mv.addObject("successMessage", "Valid Credentials");
			session.setAttribute("loginMessage", "Welcome :" +id);
		}
		else
		{
			mv.addObject("errorMessage", "InValid Credentials...please try again");
		}
		
		return mv;
		
	}

	@RequestMapping("/Logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("/Home");
		// session.invalidate();
		session.removeAttribute("loginMessage");
		return mv;
	}
	@RequestMapping("/myCart")
	public ModelAndView showMyCartPage() {
		System.out.println("Inside My Cart Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedmyCart", "true");
		return mv;
	}
	@RequestMapping("/Badminton")
	public ModelAndView showBadmintonPage() {
		System.out.println("Inside badminton Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedBadminton", "true");
		return mv;
	}
	@RequestMapping("/Cricket")
	public ModelAndView showCricketPage() {
		System.out.println("Inside cricket Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedCricket", "true");
		return mv;
	}
	@RequestMapping("/Basketball")
	public ModelAndView showBasketballPage() {
		System.out.println("Inside basketball Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedBasketball", "true");
		return mv;
	}
	@RequestMapping("/Football")
	public ModelAndView showFootballPage() {
		System.out.println("Inside football Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedFootball", "true");
		return mv;
	}
	@RequestMapping("/Golf")
	public ModelAndView showGolfPage() {
		System.out.println("Inside golf Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedGolf", "true");
		return mv;
	}
	@RequestMapping("/TableTennis")
	public ModelAndView showTableTennisPage() {
		System.out.println("Inside table tennis Page");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedTableTennis", "true");
		return mv;
	}
	
}
