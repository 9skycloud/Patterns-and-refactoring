package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public class NotSpec implements Spec {
	
	private Spec spec;
	
	public NotSpec(Spec spec) {
		this.spec = spec;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return !spec.isSatisfied(product);
	}

}
