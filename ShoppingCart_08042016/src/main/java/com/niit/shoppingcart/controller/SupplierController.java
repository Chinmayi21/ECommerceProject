package com.niit.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers(){
		 List<Supplier> suppliers = supplierDAO.list();
		return new ModelAndView("supplier", "supplierList", suppliers);
	}
	
	@RequestMapping(value = "/manage_supplier_create")
	public ModelAndView createSupplier() {
		System.out.println("manage supplier called");
		ModelAndView mv = new ModelAndView("/supplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;
	}


	@RequestMapping(value = "/create_supplier", method = RequestMethod.POST)
	public ModelAndView createSupplier(@Valid @ModelAttribute(value = "createSupplierObj") Supplier supplier,
			BindingResult result) {
		System.out.println("createSupplier called****");

		ModelAndView mv = new ModelAndView("AdminHome");
		
		if (result.hasErrors())
			return new ModelAndView("supplierForm");

		if (supplierDAO.save(supplier)) {
			mv.addObject("message", "Successfully created the Supplier");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);

		} else {
			mv.addObject("message", "Not able to create Product.Please contact Administrator");

		}
		mv.addObject("isUserClickedSuppliers", "true");
		return mv;

	}

	@RequestMapping(value = "/manage_supplier_edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSupplierEditForm(@PathVariable(value = "id") int id) {
		System.out.println("edit supplier called");
		Supplier supplier = supplierDAO.getSupplierByID(id);
		ModelAndView mv = new ModelAndView("supplierEditForm");
		mv.addObject("editSupplierObj", supplier);
		return mv;
	}

	@RequestMapping(value = "/edit_supplier", method = RequestMethod.POST)
	public String editSupplierEditForm(@ModelAttribute(value = "editSupplierObj") Supplier supplier, Model model) {
		System.out.println("edit supplier called****");
		supplierDAO.update(supplier);
		return "redirect:/getAllSuppliers";
	}
	@RequestMapping(value = "/manage_supplier_delete/{id}", method = RequestMethod.GET)
	public String deleteSupplier(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete Supplier called****");
		Supplier supplier = supplierDAO.getSupplierByID(id);
		supplierDAO.delete(supplier);
		return "redirect:/getAllSuppliers";
	}
}