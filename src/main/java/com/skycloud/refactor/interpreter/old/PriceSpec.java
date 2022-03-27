package com.skycloud.refactor.interpreter.old;


public class PriceSpec implements Spec {
	
	private float price;

	public PriceSpec(float price) {
		this.price = price;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return product.getPrice() == price;
	}

}
