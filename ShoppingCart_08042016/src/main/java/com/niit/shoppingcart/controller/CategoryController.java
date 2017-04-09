package com.niit.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;

	// Getting all Categories
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories() {
		List<Category> categories = categoryDAO.list();
		return new ModelAndView("category", "categoryList", categories);
	}

	// @PostMapping("/manage_category_create") -- does not work !

	@RequestMapping("/manage_category_create")
	public ModelAndView createCategory() {
		System.out.println("method create category called");
		ModelAndView mv = new ModelAndView("/CategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;
	}

	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@Valid @ModelAttribute(value = "createCategoryObj") Category category,
			BindingResult result) {
		System.out.println("create category called*****************");

		ModelAndView mv = new ModelAndView("AdminHome");
		if (result.hasErrors())
			return new ModelAndView("CategoryForm");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);

		} else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}
		mv.addObject("isUserClickedCategories", "true");
		return mv;

	}

	@RequestMapping(value = "/manage_category_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete Category called****");

		/*
		 * ModelAndView mv = new ModelAndView("/Admin/Category");
		 * mv.addObject("isUserClickedCategories", "true"); Category category =
		 * (Category) categoryDAO.getCategoryByID(id); if
		 * (categoryDAO.delete(category)) { mv.addObject("messsage",
		 * "Successfully deleted the category"); } else {
		 * mv.addObject("messsage",
		 * "Not able to delete the  category,so please contact administrator");
		 * }
		 * 
		 * model.addAttribute("categoryList", categoryDAO.list());
		 * List<Category> categoryList = categoryDAO.list();
		 * mv.addObject("categoryList", categoryList); mv.addObject("category",
		 * category);
		 * 
		 * return mv; // return "forward:Category";
		 * 
		 * 
		 */

		Category category = categoryDAO.getCategoryByID(id);
		categoryDAO.delete(category);
		return "redirect:/getAllCategories";
	}

	// method for edit
	// when clicked on edit, the data should be retrieved in the
	// categoryeditform
	// , i.e GET the data

	@RequestMapping(value = "/manage_category_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getCategoryEditForm(@PathVariable("id") int id) {
		System.out.println("edit method called");

		Category category = categoryDAO.getCategoryByID(id);
		// can also use this keyword
		// Category category = this.categoryDAO.getCategoryById(id);
		ModelAndView mv = new ModelAndView("CategoryEditForm");
		mv.addObject("editCategoryObj", category);
		return mv;
	}

	// Method 2
	// When clicked on edit category button in categoryEditform page, it should
	// edit and update

	@RequestMapping(value = "/manage_category_edit", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute(value = "editCategoryObj") Category category, Model model) {
		System.out.println("edit category called****");
		/*
		 * ModelAndView mv = new ModelAndView("Admin/Category"); if
		 * (categoryDAO.update(category)) { mv.addObject("message",
		 * "Category edited successfully"); List<Category> categoryList =
		 * categoryDAO.list(); mv.addObject("categoryList", categoryList);
		 * mv.addObject("category", category); } else { mv.addObject("message",
		 * "Not able to edit category, contact administrator"); }
		 * mv.addObject("isUserClickedCategories", "true");
		 * 
		 */

		categoryDAO.update(category);
		return "redirect:/getAllCategories";
	}
}
