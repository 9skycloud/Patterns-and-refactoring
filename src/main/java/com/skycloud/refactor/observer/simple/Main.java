package com.skycloud.refactor.observer.simple;

public class Main {

	public static void main(String[] args) {
		WeatherMonitor monitor = new WeatherMonitor();
		ObserverService ob1 = new Observer1("zhangsan");
		monitor.subscribe(ob1);
		
		ObserverService ob2 = new Observer2("lisi");
		monitor.subscribe(ob2);
		 
		System.out.println("-------我是天气预报员，我观察到今天天气晴朗！--------");
		monitor.notifyAllObserver("sun");
		System.out.println("-------我是天气预报员，我观察到今天有雨，我要通知我的订阅者！--------");
		monitor.notifyAllObserver("rain");
	}

}
