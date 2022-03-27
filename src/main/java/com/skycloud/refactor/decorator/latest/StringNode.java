package com.skycloud.refactor.decorator.latest;

import org.htmlparser.lexer.Page;
import org.htmlparser.util.ParserUtils;
import org.htmlparser.visitors.NodeVisitor;

import com.skycloud.refactor.decorator.old.AbstractNode;
import com.skycloud.refactor.decorator.old.Node;

public class StringNode extends AbstractNode implements Node{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
		this.textBuffer = textBuffer;
		this.shouldDecode = shouldDecode;
	}

	public StringNode(StringBuffer textBuffer, int textBegin, int textEnd,
			boolean shouldDecode, boolean shouldRemoveEscapeCharacters) {
		this.textBuffer = textBuffer;
		this.shouldDecode = shouldDecode;
		this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
	}

	private boolean shouldDecode = false;
	private boolean shouldRemoveEscapeCharacters = false;
	private StringBuffer textBuffer;


	public String toPlainTextString() {
		String result = this.textBuffer.toString();

		if (this.shouldDecode) {
			result = Translate.decode(result);
		}

		if (this.shouldRemoveEscapeCharacters) {
			result = ParserUtils.removeEscapeCharacters(result);
		}
		return result;
	}

	@Override
	public String toHtml(boolean verbatim) {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		
	}
	
	public Node createStringNode(StringBuffer sb,int start,int end,boolean shouldDecode){
		if(shouldDecode)
			return new DecoratorNode(new StringNode(sb,start,end));
		return new StringNode(sb,start,end);
	}

	@Override
	public Page getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPage(Page page) {
		// TODO Auto-generated method stub
		
	}
	
}
