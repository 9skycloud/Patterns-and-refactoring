package com.skycloud.refactor.simplify.composed.simple;

public class Ring implements CalculatePriceService{

	private String id;
	
	private String spec;
	
	private String type;
	
	private float price;
	
	

	public Ring(String id, float price) {
		this.id = id;
		this.price = price;
	}

	public Ring(String id, String spec, String type, float price) {
		this.id = id;
		this.spec = spec;
		this.type = type;
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
