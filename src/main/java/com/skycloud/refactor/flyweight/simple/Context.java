package com.skycloud.refactor.flyweight.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Context {

	private BookMan book;
	
	private FlyweightFactory factory;

	public BookMan getBook() {
		return book;
	}

	public void setBook(BookMan book) {
		this.book = book;
	}

	public FlyweightFactory getFactory() {
		return factory;
	}

	public void setFactory(FlyweightFactory factory) {
		this.factory = factory;
	}
	
	public void weightLift(String tshirt,String appearance){
		factory.get(tshirt, appearance).weightLift(book);
	}

	
	
	
}

