package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public class SizeSpec implements Spec {
	
	private int size;

	public SizeSpec(int size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.getSize() == size;
	}

}
