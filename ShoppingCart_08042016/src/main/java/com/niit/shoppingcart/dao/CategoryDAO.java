package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

public interface CategoryDAO {
	// declare methods for CRUD operations

	// get all categories
	public List<Category> list();

	// create category
	public boolean save(Category category);

	// update category
	public boolean update(Category category);

	// delete category by category(entirely)
	public boolean delete(Category category);

	// get category by id
	public Category getCategoryByID(int id);

	// get category by name
	public Category getCategoryByName(String name);
}
