package com.skycloud.refactor.simplify.composed.simple;

import java.util.ArrayList;
import java.util.List;

public class Egg implements CalculatePriceService{

	private String id;
	
	private String size;
	
	private float price;
	
	private List<Egg> children = new ArrayList<Egg>();
	
	public Egg() {
	}

	public Egg(String id, float price) {
		this.id = id;
		this.price = price;
	}




	public Egg(String id, String size, float price, List<Egg> children) {
		this.id = id;
		this.size = size;
		this.price = price;
		this.children = children;
	}
	
	public void add(Egg e){
		this.children.add(e);
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalPrice(){
		float total = 0;
		for(Egg egg:children){
			total += egg.price;
		}
		return total;
	}


	@Override
	public float calculate() {
		return getTotalPrice();
	}
	
}
