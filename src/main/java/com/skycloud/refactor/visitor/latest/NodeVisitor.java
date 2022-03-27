package com.skycloud.refactor.visitor.latest;

import com.skycloud.refactor.visitor.HTMLNode;

public interface NodeVisitor {

	public abstract void visitHtmlTag(HTMLNode node);

	public abstract void visitEndTag(HTMLNode node);

	public abstract void visitLinkTag(HTMLNode node);

	public abstract void visitStringNode(HTMLNode node);

}