package com.skycloud.refactor.simplify.decorator.latest;

public class StringNode implements Node{
	
	private String text;
	
	public StringNode(String text) {
		super();
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}


}
