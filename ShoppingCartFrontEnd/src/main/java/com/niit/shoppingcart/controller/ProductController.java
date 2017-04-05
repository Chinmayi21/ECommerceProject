package com.niit.shoppingcart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class ProductController {

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	// Getting all products
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {
		List<Product> products = productDAO.list();
		return new ModelAndView("product", "productList", products);
	}

	@RequestMapping("/manage_product_create")
	public ModelAndView createProduct() {
		System.out.println("method create product called");
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject("createProductObj", product);
		mv.addObject("productList", this.productDAO.list());
		mv.addObject("category", new Category());
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", this.supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product,MultipartFile file, Model model,
			BindingResult result) {

		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("AdminHome");
		if (result.hasErrors())
			return new ModelAndView("createProductForm");

		else {
			Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
			System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());

			Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
			System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

			product.setCategory(category);
			product.setSupplier(supplier);
			productDAO.save(product);
			mv.addObject("isUserClickedProducts", "true");
			mv.addObject("productList", productDAO.list());

			// add images in products
			MultipartFile prodImage = product.getImage();
			System.out.println(prodImage);
			if (prodImage != null || !prodImage.isEmpty()) {

				// storing the image

				Path paths = Paths.get("F:/workspace/ShoppingCartFrontEnd/src/main/webapp/WEB-INF/resources/images/"
						+ product.getId() + ".png");

				try {
					prodImage.transferTo(new File(paths.toString()));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mv;

	}

	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete Product called****");
		Product product = productDAO.getProductById(id);
		productDAO.delete(product);

		// delete images
		Path paths = Paths.get("F:/workspace/ShoppingCartFrontEnd/src/main/webapp/WEB-INF/resources/images/"
				+ product.getId() + ".png");

		if (Files.exists(paths)) {
			try {
				Files.delete(paths);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/getAllProducts";
	}

	// method for edit
	// when clicked on edit, the data should be retrieved in the
	// producteditform
	// , i.e GET the data

	@RequestMapping(value = "/manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getProductEditForm(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("edit method called");

		Product product = productDAO.getProductById(id);
		ModelAndView mv = new ModelAndView("ProductEditForm");
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplierList", this.supplierDAO.list());
		mv.addObject("editProductObj", product);
		return mv;
	}

	// Method 2
	// When clicked on edit product button in productEditform page, it should
	// edit and update

	@RequestMapping(value = "/product_edit", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product,MultipartFile file, Model model) {
		System.out.println("edit product called****");
		productDAO.update(product);
		MultipartFile prodImage = product.getImage();
		System.out.println(prodImage);
		if (prodImage != null || !prodImage.isEmpty()) {

			// storing the image

			Path paths = Paths.get("F:/workspace/ShoppingCartFrontEnd/src/main/webapp/WEB-INF/resources/images/"
					+ product.getId() + ".png");

			try {
				prodImage.transferTo(new File(paths.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		return "redirect:/getAllProducts";
	}
}
