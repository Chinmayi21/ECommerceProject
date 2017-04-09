package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	// create supplier
	public boolean save(Supplier supplier);

	// update supplier
	public boolean update(Supplier supplier);

	// delete supplier by id
	//public boolean delete(int id);

	// delete supplier by supplier(entirely)
	public boolean delete(Supplier supplier);

	// get supplier by id
	public Supplier getSupplierByID(int id);

	// get supplier by name
	public Supplier getSupplierByName(String name);
}
