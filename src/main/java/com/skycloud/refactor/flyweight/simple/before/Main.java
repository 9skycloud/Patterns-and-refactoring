package com.skycloud.refactor.flyweight.simple.before;

import com.skycloud.refactor.flyweight.simple.BookMan;
import com.skycloud.refactor.flyweight.simple.Context;
import com.skycloud.refactor.flyweight.simple.FlyweightFactory;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * BigFatMan big1 = new BigFatMan("maket1", "黄色T恤", "大白", "三角形");
		BigFatMan big2 = new BigFatMan("maket2", "黄色T恤", "大白", "四角形");
		BigFatMan big3 = new BigFatMan("maket3", "黄色T恤", "大白", "五角形");
		BigFatMan big4 = new BigFatMan("maket4", "黄色T恤", "大白", "六角形");
		BigFatMan big5 = new BigFatMan("maket5", "黄色T恤", "大白", "七角形");
		
		big1.weightLift();
		big2.weightLift();
		big3.weightLift();
		big4.weightLift();
		big5.weightLift();*/
		
//		SmallMan small1 = new SmallMan("黄色T恤", "大白");
		FlyweightFactory factory = new FlyweightFactory();
		factory.add("黄色T恤", "大白");
		
		Context context = new Context();
		context.setFactory(factory);
		BookMan book1 = new BookMan("maket1", "三角形");
		BookMan book2 = new BookMan("maket2", "四角形");
		BookMan book3 = new BookMan("maket3", "五角形");
		BookMan book4 = new BookMan("maket4", "六角形");
		BookMan book5 = new BookMan("maket5", "七角形");
		
		context.setBook(book1);
		context.weightLift("黄色T恤", "大白");
		
		context.setBook(book2);
		context.weightLift("黄色T恤", "大白");
		
		context.setBook(book3);
		context.weightLift("黄色T恤", "大白");
		
		context.setBook(book4);
		context.weightLift("黄色T恤", "大白");
		
		context.setBook(book5);
		context.weightLift("黄色T恤", "大白");
		
		
		
	}

}

