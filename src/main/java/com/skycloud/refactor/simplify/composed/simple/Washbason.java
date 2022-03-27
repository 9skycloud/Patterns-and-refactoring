package com.skycloud.refactor.simplify.composed.simple;

import java.util.Date;

public class Washbason implements CalculatePriceService{

	private String id;
	
	private String color;
	
	private String size;
	
	private String factory;
	
	private Date productDate;
	
	private float price;

	public Washbason(String id, float price) {
		this.id = id;
		this.price = price;
	}

	public Washbason(String id, String color, String size, String factory,
			Date productDate, float price) {
		this.id = id;
		this.color = color;
		this.size = size;
		this.factory = factory;
		this.productDate = productDate;
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public float calculate() {
		return price;
	}
	
}
