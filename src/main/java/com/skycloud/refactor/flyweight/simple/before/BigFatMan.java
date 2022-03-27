package com.skycloud.refactor.flyweight.simple.before;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class BigFatMan {

	private String name;
	
	private String tshirt;
	
	private String appearance;
	
	private String signShape;

	public BigFatMan(String name, String tshirt, String appearance,
			String signShape) {
		this.name = name;
		this.tshirt = tshirt;
		this.appearance = appearance;
		this.signShape = signShape;
	}
	
	public void weightLift(){
		System.out.println(name+"穿着："+this.signShape +"图案的 "+this.tshirt +"的 "+this.appearance +"对象【举重】");
	}
	
	
	
}

