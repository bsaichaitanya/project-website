package com.niit.domainobject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="Product")
@Component
public class Product {

	@Id 
	private String productID;
	
	@NotEmpty 
	private String name;
	
	@NotNull 
	private String description;
	
	@NotNull 
	private String categoryID;
	
	@NotNull 
	private String supplierID;
	 
	@NotNull
	@Column(length = 8, precision = 2)
	private double price;

	@NotNull
	private String size;
	
	@NotNull
	private int stock;
	
	@Transient
	private MultipartFile image;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "supplierID", updatable= false, insertable= false, nullable=false)
	private Supplier supplier;
	
	
	
	

	@ManyToOne
	@JoinColumn(name = "categoryID", updatable= false, insertable= false, nullable=false)
	private Category category;
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	



	
	
}
