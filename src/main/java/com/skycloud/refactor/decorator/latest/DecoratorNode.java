package com.skycloud.refactor.decorator.latest;

import org.htmlparser.lexer.Page;
import org.htmlparser.visitors.NodeVisitor;

import com.skycloud.refactor.decorator.old.AbstractNode;
import com.skycloud.refactor.decorator.old.Node;

public class DecoratorNode extends AbstractNode implements Node{
	
	private boolean shouldDecode;
	
	private Node node;

	public DecoratorNode(Node node) {
		node = node;
	}

	@Override
	public String toPlainTextString() {
		return Translate.decode(node.toPlainTextString());
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

	public boolean isShouldDecode() {
		return true;
	}

}
