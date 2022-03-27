package com.skycloud.refactor.simplify.composed.old;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private List<Product> products;

	public Order(int id) {
		this.products = new ArrayList<Product>();
		this.id = id;
	}

	public int OrderId() {
		return this.id;
	}

	public void Add(Product product) {
		this.products.add(product);
	}

	public int ProductCount() {
		return this.products.size();
	}

	public Product Product(int insertionIndex) {
		return this.products.get(insertionIndex);
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
}
