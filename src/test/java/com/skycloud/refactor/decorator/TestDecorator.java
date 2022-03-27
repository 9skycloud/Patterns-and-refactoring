package com.skycloud.refactor.decorator;

import junit.framework.Assert;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.lexer.Page;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.DefaultParserFeedback;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.Translate;
import org.junit.Test;

public class TestDecorator {
	
	protected Parser parser;
	
	protected Node node [];
    protected int nodeCount;
    protected Lexer mLexer;
	
	String encode_title = "the testing &amp; refactoring workshop";
	
	String decode_title = "the testing & refactoring workshop";
	
	@Test
	public void testDecodingAmpersand() throws Exception{
		Assert.assertEquals(decode_title, parseToObtainDecodedResult(encode_title));
	}
	
	private String parseToObtainDecodedResult(String stringToDecode) throws ParserException{
		StringBuffer sb = new StringBuffer();
		createParser(stringToDecode);
		NodeIterator nodes = parser.elements();
		while(nodes.hasMoreNodes()){
			Node node = nodes.nextNode();
			if(node instanceof TextNode){
				TextNode str = (TextNode) node;
				sb.append(Translate.decode(str.getText()));
			}
			if(node instanceof Tag)
				sb.append(node.toHtml());
		}
		return sb.toString();
	}

	protected void createParser(String inputHTML) {
        mLexer =  new Lexer (new Page (inputHTML));
        parser = new Parser(mLexer, new DefaultParserFeedback(DefaultParserFeedback.QUIET));
        node = new Node[40];
    }
}
