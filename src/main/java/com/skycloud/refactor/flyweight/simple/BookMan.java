package com.skycloud.refactor.flyweight.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class BookMan {

	private String name;
	
	private String signShape;

	public BookMan(String name, String signShape) {
		this.name = name;
		this.signShape = signShape;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignShape() {
		return signShape;
	}

	public void setSignShape(String signShape) {
		this.signShape = signShape;
	}
	
}

