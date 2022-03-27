package com.skycloud.refactor.interpreter.old;

import java.awt.Color;

public class Product {

	private String name;
	
	private Color color;
	
	private float price;
	
	private int size;
	

	public Product(String name, Color color, float price, int size) {
		this.name = name;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
