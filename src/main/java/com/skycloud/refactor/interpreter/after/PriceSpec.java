package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public class PriceSpec implements Spec {

	private float priceLimit;
	
	public PriceSpec(float price) {
		this.priceLimit = price;
	}
	
	@Override
	public boolean isSatisfied(Product product) {
		return product.getPrice() == priceLimit;	}


}
