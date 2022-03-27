package com.skycloud.refactor.creative.factory.old;



/**
 * HTML解析器项目
 * @author QQ445161315
 *
 */
public class StringParser {
	
	private Parser parser;
	
	public StringParser(Parser parser) {
		this.parser = parser;
	}

	public Node find(String textBuffer){
		return parser.getFactory().createStringNode(textBuffer,parser.getFactory().shouldDecodeNodes);
	}
}


