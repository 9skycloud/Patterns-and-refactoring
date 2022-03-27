package com.skycloud.refactor.interpreter.after;

import com.skycloud.refactor.interpreter.old.Product;

public interface Spec {

	boolean isSatisfied(Product product);
	
}
