package com.skycloud.refactor.flyweight.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class SmallMan {

	private String tshirt;
	
	private String appearance;

	public SmallMan(String tshirt, String appearance) {
		this.tshirt = tshirt;
		this.appearance = appearance;
	}
	
	public void weightLift(BookMan book){
		System.out.println(book.getName()+"穿着："+book.getSignShape() +"图案的 "+this.tshirt +"的 "+this.appearance +"对象【举重】");
	}
	
}

