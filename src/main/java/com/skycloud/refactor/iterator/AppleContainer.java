package com.skycloud.refactor.iterator;

import java.util.ArrayList;
import java.util.List;

public class AppleContainer {
	
	private List<Apple> list = new ArrayList<>();

	
	public void add(Apple apple){
		this.list.add(apple);
	}
	
	public void remove(Apple apple){
		this.list.remove(apple);
	}
	
	
	public IteratorService createIterator(){
		return new IteratorImpl(list);
	}
	
}
