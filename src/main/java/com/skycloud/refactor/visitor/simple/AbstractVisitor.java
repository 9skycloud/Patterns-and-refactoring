package com.skycloud.refactor.visitor.simple;

public interface AbstractVisitor {

	public void visit(Forest forest);
	public void visit(GrassLand grass);
	public void visit(Pond pond);
	
}
