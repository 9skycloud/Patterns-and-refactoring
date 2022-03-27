package com.skycloud.refactor.interpreter.old;

public class SizeSpec implements Spec {
	
	private int size;
	
	public SizeSpec(int size){
		this.size = size;
	}

	@Override
	public boolean isSatisfiedBy(Product product) {
		return product.getSize() == size;
	}

}
