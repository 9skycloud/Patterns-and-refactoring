package com.skycloud.refactor.creative.factory.old;

public class DecodingStringNode extends Node{
	
	StringNode stringNode;
	
	public DecodingStringNode(StringNode stringNode) {
		this.stringNode = stringNode;
	}
	
	public String getText() {
		return convertString(
				stringNode.getText()
			);
	}
	
	private String convertString(String input){
		return input.replace("&nbsp;","&");
	}
	
}
