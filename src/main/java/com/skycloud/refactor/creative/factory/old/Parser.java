package com.skycloud.refactor.creative.factory.old;

public class Parser{
	
	private StringParser stringParser;
	
	private NodeFactory factory;

	public Parser(NodeFactory factory) {
		this.factory = factory;
	}
	
	public NodeFactory getFactory() {
		return factory;
	}

	public void setFactory(NodeFactory factory) {
		this.factory = factory;
	}

	public Parser() {
		this.stringParser = new StringParser(this);
	}
	
	public Node parse(String url) {
	    return this.stringParser.find(url);
	}
	
}
