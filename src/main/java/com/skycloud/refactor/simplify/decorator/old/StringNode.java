package com.skycloud.refactor.simplify.decorator.old;

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

	@Override
	public String decode(String str) {
		return text.replace("&nbsp;", "");
	}

}
