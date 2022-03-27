package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public class AndSpec implements Spec {
	
	private Spec left;
	private Spec right;
	
	

	public AndSpec(Spec left, Spec right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return left.isSatisfied(product) && right.isSatisfied(product);
	}

}
