package com.skycloud.refactor.interpreter.old;

public class BelowPriceSpec implements Spec {
	
	private float priceThreshold;
	
	public BelowPriceSpec(float priceThreshold) {
		this.priceThreshold = priceThreshold;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return product.getPrice() < priceThreshold;
	}

}
