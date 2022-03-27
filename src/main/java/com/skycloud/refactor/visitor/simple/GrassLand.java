package com.skycloud.refactor.visitor.simple;

public class GrassLand implements AbstractElement{

	private long area;
	
	private String name;
	
	private float x;
	
	private float y;
	
	public String getGrass(){
		return "2000kg草";
	}
	
	public String grassReport(){
		return "10%草受虫害";
	}

	@Override
	public void accept(AbstractVisitor v) {
		v.visit(this);
	}
}
