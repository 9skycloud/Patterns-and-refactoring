package com.skycloud.refactor.observer.simple;

public class Observer2 implements ObserverService {
	
	private String name;

	public Observer2(String name) {
		this.name = name;
	}
	
	public void sun(){
		System.out.println("我是："+name+";天气不错，我要晒太阳！");
	}
	
	public void goHome(){
		System.out.println("我是"+name+";天气不太好，我要收回家！");
	}
	
	public void fire(String input){
		if(input.indexOf("sun")>-1){
			this.sun();
		}
		if(input.indexOf("rain")>-1){
			this.goHome();
		}
	}
	

}
