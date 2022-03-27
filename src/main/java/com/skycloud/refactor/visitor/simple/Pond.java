package com.skycloud.refactor.visitor.simple;

public class Pond implements AbstractElement {

	private float width;
	
	private float length;
	
	private String name;
	
	public String getWater(){
		return "水";
	}
	
	public String report(){
		return "浑浊度：20%;污染：3%";
	}
	
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.visitor.simple.AbstractElement#accept(com.skycloud.refactor.visitor.simple.AbstractVisitor)
	 */
	@Override
	public void accept(AbstractVisitor v){
		v.visit(this);
	}
}
