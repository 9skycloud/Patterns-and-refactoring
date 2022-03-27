package com.skycloud.refactor.interpreter.old;

import java.awt.Color;

public class ColorSpec implements Spec {

	private Color color;

	public ColorSpec() {
	}

	public ColorSpec(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean isSatisfiedBy(Product product){
		return product.getColor() == color;
	}
	
}
