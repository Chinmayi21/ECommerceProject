package com.niit.shoppingcart.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.ApplicationContextConfig;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;

	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void initialization() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void saveproductTestCase() {
		product.setId(1);
		product.setName("Shoes");
		product.setPrice(500);
		boolean flag = productDAO.save(product);
		Assert.assertEquals("updateproductTestCase", true, flag);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void updateproductTestCase() {
		product.setId(3);
		product.setName("Shoes");
		product.setPrice(300);
		boolean flag = productDAO.save(product);
		Assert.assertEquals("updateproductTestCase", true, flag);
	}

	@Test
	public void deleteproductTestCase() {
		Product product = productDAO.getProductById(3);
		boolean flag = productDAO.delete(product);
		// boolean flag = productDAO.delete("01032017");
		Assert.assertEquals(true, flag);
	}

	@Test
	public void getProductByIDTestCase() {
		product = productDAO.getProductById(3);
		// Assert.assertEquals("getproductByIDTestCase" ,null, product); or
		// use assert not null
		Assert.assertNotNull(null, product);
	}

	@Test
	public void getproductByNameTestCase() {
		product = productDAO.getProductByName("Trousers");
		// Assert.assertEquals("getproductByNameTestCase" ,null, product); or
		// use assert not null
		Assert.assertNotNull(null, product);
	}

	@Test
	public void getAllCategoriesTestCase() {
		int recordsfromDAO = productDAO.list().size();
		assertEquals("getAllCategoriesTestCase", 5, recordsfromDAO);
	}
}
