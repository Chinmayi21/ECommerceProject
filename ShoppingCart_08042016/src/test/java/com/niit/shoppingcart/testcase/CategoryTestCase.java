package com.niit.shoppingcart.testcase;

import javax.validation.constraints.AssertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CategoryTestCase {

	@Autowired
	private static Category category; // conversion to static as static methods
										// execute only static methods and
										// variables

	@Autowired
	private static CategoryDAO categoryDAO;

	// init method(initialization) - to be execute only once

	@BeforeClass // to execute any code before the context
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	// TEST CASES

//	@Test
	public void createCategoryTestCase() {
		category.setId(123);
		category.setName("Shoes");
		category.setDescription("nike");

		boolean flag = categoryDAO.save(category); // 'save' method is boolean;
		// assume it to be true as the test case may be pass or fail

		// compare the expected and what we have received ; use assert
		// statements

		Assert.assertEquals("createCategoryTestCase", true, flag);
	}

	@Test
	public void updateCategoryTestCase() {
		category.setId(2);
		category.setName("shooeess");
		category.setDescription("nikeee");
		boolean flag = categoryDAO.save(category);
		Assert.assertEquals("updateCategoryTestCase", true, flag);
	}

	//@Test
	public void deleteCategoryTestCase() {
		Category category = categoryDAO.getCategoryByID(1);
		boolean flag = categoryDAO.delete(category);
		// boolean flag = categoryDAO.delete("01032017");
		Assert.assertEquals(true, flag);

	}

	//@Test
	public void getCategoryByIDTestCase() {
		category = categoryDAO.getCategoryByID(002);
		// Assert.assertEquals("getCategoryByIDTestCase" ,null, category); or
		// use assert not null
		Assert.assertNotNull(null, category);
	}

	//@Test
	public void getCategoryByNameTestCase() {
		category = categoryDAO.getCategoryByName("Food Category");
		// Assert.assertEquals("getCategoryByNameTestCase" ,null, category); or
		// use assert not null
		Assert.assertNotNull(null, category);
	}

	//@Test
	public void getAllCategoriesTestCase() {
		int recordsfromDAO = categoryDAO.list().size();
		Assert.assertEquals("getAllCategoriesTestCase", 4, recordsfromDAO);
	}
}
