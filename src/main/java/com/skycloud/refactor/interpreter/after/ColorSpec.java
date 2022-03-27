package com.skycloud.refactor.interpreter.after;

import java.awt.Color;

import com.skycloud.refactor.interpreter.old.Product;

public class ColorSpec implements Spec {
	
	private Color color;
	
	public ColorSpec(Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.getColor() == color;
	}

}
