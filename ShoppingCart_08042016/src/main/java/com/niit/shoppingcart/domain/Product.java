package com.niit.shoppingcart.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity

@Component
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private int price;

	@Transient
	private MultipartFile image;

	public Product(){
		
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "category_id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "supplier_id")
	private Supplier supplier;
	
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category=category;
	}
	
	public Supplier getSupplier(){
		return supplier;
	}

	public void setSupplier(Supplier supplier){
		this.supplier= supplier;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@Override
	public String toString(){
		return "Product[id=" +id +",name="+name+",price="+price+",category="+category+",supplier"+supplier+"]";
	}
}
