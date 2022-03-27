package com.skycloud.refactor.decorator.old;

import org.htmlparser.lexer.Page;
import org.htmlparser.util.ParserUtils;
import org.htmlparser.visitors.NodeVisitor;

public class StringNode extends AbstractNode implements Node {
	private boolean shouldDecode = false;
	private boolean shouldRemoveEscapeCharacters = false;
	private StringBuffer textBuffer;

	StringNode(StringBuffer textBuffer, int textBegin, int textEnd,
			boolean shouldDecode, boolean shouldRemoveEscapeCharacters) {
		this.textBuffer = textBuffer;
		this.shouldDecode = shouldDecode;
		this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
	}

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
	public Node getParent() {
		return null;
	}

	@Override
	public Node getFirstChild() {
		return null;
	}

	@Override
	public Node getLastChild() {
		return null;
	}

	@Override
	public Node getPreviousSibling() {
		return null;
	}

	@Override
	public Node getNextSibling() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void setParent(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toHtml(boolean verbatim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub

	}
}
