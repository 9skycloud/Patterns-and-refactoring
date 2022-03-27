package com.skycloud.refactor.interpreter.old;


public class NotColorSpec implements Spec {
	
	private Spec spec;

	public NotColorSpec(Spec spec) {
		this.spec = spec;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return !spec.isSatisfiedBy(product);
	}

}
