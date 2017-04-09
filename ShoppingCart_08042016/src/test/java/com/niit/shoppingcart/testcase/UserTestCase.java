package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.ApplicationContextConfig;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	private static ApplicationContextConfig context;

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void saveUserTestCase() {
		user.setId("test");
		user.setName("testname");
		user.setPassword("pwd");
		user.setContact("9761464784");
		user.setRole("role_user");
		user.setAddress("Bangalore");
		user.setEmail("test@gmail.com");
		boolean flag = userDAO.save(user);
		Assert.assertEquals(true, flag);
	}

	@Test
	public void validateCredentialsTestCase() {
		boolean flag = userDAO.validate("test", "pwd");
		Assert.assertEquals(true, flag);
	}

	@Test
	public void updateUserTestCase() {
		user.setId("test1");
		user.setName("testname");
		user.setPassword("pwd");
		user.setContact("9761464784");
		user.setRole("role_user");
		user.setAddress("Bangalore");
		user.setEmail("test@gmail.com");
		boolean flag = userDAO.update(user);
		Assert.assertEquals(true, flag);
	}

	@Test
	public void getCategoryByIDTestCase() {
		user = userDAO.getUser("test");
		// Assert.assertEquals("getCategoryByIDTestCase" ,null, category); or
		// use assert not null
		Assert.assertNotNull(null, user);
	}

	@Test
	public void getAllUserTestCase() {
		int recordsfromDAO = userDAO.list().size();
		assertEquals("getAllUserTestCase", 4, recordsfromDAO);
	}

	@Test
	public void deleteCategoryTestCase() {
		User user = userDAO.getUser("test1");
		boolean flag = userDAO.delete(user);
		Assert.assertEquals(true, flag);

	}
}
