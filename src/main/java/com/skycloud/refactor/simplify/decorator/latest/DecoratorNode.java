package com.skycloud.refactor.simplify.decorator.latest;

public class DecoratorNode implements Node{
	
	private Node entrust;
	
	public DecoratorNode(Node entrust) {
		super();
		this.entrust = entrust;
	}

	@Override
	public String getText() {
		return decode(entrust.getText());
	}

	public String decode(String str) {
		return str.replace("&nbsp;", "");
	}

}
