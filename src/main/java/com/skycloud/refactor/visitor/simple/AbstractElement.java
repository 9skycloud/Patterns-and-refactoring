package com.skycloud.refactor.visitor.simple;

public interface AbstractElement {

	public abstract void accept(AbstractVisitor v);

}