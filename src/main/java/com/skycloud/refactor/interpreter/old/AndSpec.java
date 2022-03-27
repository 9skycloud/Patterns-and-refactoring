package com.skycloud.refactor.interpreter.old;

public class AndSpec implements Spec {
	
	private Spec left;
	
	private Spec right;
	
	public AndSpec(Spec left, Spec right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return left.isSatisfiedBy(product) && right.isSatisfiedBy(product);
	}

}
