package com.skycloud.refactor.simplify.composed.old;

public class Product {

	private int id;
	private String name;
	private String price;
	private ProductSize size;

	public Product(int id, String name, ProductSize size, String price) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public ProductSize getSize() {
		return size;
	}

	public void setSize(ProductSize size) {
		this.size = size;
	}

}
