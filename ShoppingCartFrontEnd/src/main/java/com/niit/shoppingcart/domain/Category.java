package com.niit.shoppingcart.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

@Entity // maps the category class to the category table in database

// if same name is not taken, then @table(name= "<table-name>") here @Table(name
// = "category")
@Component // The instance of the class needs to be created
public class Category implements Serializable{
	// add properties similar to category table created in h2 database!
	// same class name and table name is preferred

	// generate getter setter methods

	@Id // since it is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name") // Only when field name and property name is
							// different
	private String name;

	private String description;
	
	public Category(){
		
	}
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	private List<Product> products;
	
	public List<Product> getProducts(){
		return products;
	}

	public void setProducts(List<Product> products){
		this.products= products;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
