package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class AdminController {

	// defining the methods

	// to get the categories
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories() {
		System.out.println("manage categories");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedCategories", "true");
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);

		return mv;
	}

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers() {
		System.out.println("manage suppliers");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);

		return mv;
	}

	@Autowired 
	Product product;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/manage_products")
	public ModelAndView manageProducts() {
		System.out.println("manage products");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		List<Product> productList = productDAO.list();
		mv.addObject("productList", productList);
		mv.addObject("product", product);

		return mv;
	}

}
