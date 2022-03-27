package com.skycloud.refactor.decorator.old;

public class NodeReader {
	private Parser parser;

	void NodeReader() {
		this.parser = new Parser();
	}

	/**
	 * getParser
	 */
	public Parser getParser() {
		return this.parser;
	}
}
