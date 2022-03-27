package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public class BelowSpec implements Spec {
	
	private float price;
	
	public BelowSpec(float price) {
		this.price = price;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.getPrice() < price;
	}

}
