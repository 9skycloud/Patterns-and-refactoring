package com.skycloud.refactor.visitor.simple;

public class Forest implements AbstractElement{
	
	private float area;
	
	private float x;
	
	private float y;
	
	private String treeName;

	
	public String getTree(){
		return "20跟木头";
	}
	
	public String report(){
		return "3000杨树，5000柏树";
	}

	@Override
	public void accept(AbstractVisitor v) {
		v.visit(this);
	}
}
