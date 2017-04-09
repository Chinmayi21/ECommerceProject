package com.niit.shoppingcart.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@SuppressWarnings("deprecation")

	//@Test
	/*public void createSupplierTestCase() {
		supplier.setId("78");
		supplier.setName("ABC");
		supplier.setAddress("Jaynagar,Bangalore");
		boolean flag = supplierDAO.save(supplier);
		Assert.assertEquals(true, flag);

	}*/

	@Test
	public void updateSupplierTestCase() {
		supplier.setId(28);
		supplier.setName("shooeess");
		supplier.setAddress("nikeee");
		boolean flag = supplierDAO.save(supplier);
		Assert.assertEquals("updateCategoryTestCase", true, flag);
	}

	//@Test
	public void deleteSupplierTestCase() {
		Supplier supplier = supplierDAO.getSupplierByID(5);
		boolean flag = supplierDAO.delete(supplier);
		Assert.assertEquals(true, flag);

	}

	//@Test
	public void getSupplierByIDTestCase() {
		supplier = supplierDAO.getSupplierByID(2);
		// Assert.assertEquals("getSupplierByIDTestCase" ,null, Supplier); or
		// use assert not null
		Assert.assertNotNull(null, supplier);
	}

	//@Test
	public void getSupplierByNameTestCase() {
		supplier = supplierDAO.getSupplierByName("Food Supplier");
		// Assert.assertEquals("getSupplierByNameTestCase" ,null, Supplier); or
		// use assert not null
		Assert.assertNotNull(null, supplier);
	}

	//@Test
	public void getAllCategoriesTestCase() {
		int recordsfromDAO = supplierDAO.list().size();
		assertEquals("getAllCategoriesTestCase", 7, recordsfromDAO);
	}
}
