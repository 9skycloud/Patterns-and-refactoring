package com.skycloud.refactor.observer.simple;

public class Observer1 implements ObserverService{
	
	private String name;

	public Observer1(String name) {
		this.name = name;
	}
	
	public void dryingQuilt(){
		System.out.println("我是："+name+";天气不错，我要晒被子！");
	}
	
	public void collectTheQuilt(){
		System.out.println("我是"+name+";天气不太好，我要收被子！");
	}
	
	public void fire(String input){
		if(input.indexOf("sun")>-1){
			this.dryingQuilt();
		}
		if(input.indexOf("rain")>-1){
			this.collectTheQuilt();
		}
	}
	

}
