package com.skycloud.refactor.proxy.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Egg {

	private String id;
	
	private String name;
	
	private String spec;
	
	private float price;

	public Egg(String id, String name, String spec, float price) {
		this.id = id;
		this.name = name;
		this.spec = spec;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Egg [id=" + id + ", name=" + name + ", spec=" + spec
				+ ", price=" + price + "]";
	}
	
}

