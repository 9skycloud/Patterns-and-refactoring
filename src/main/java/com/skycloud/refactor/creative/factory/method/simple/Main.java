package com.skycloud.refactor.creative.factory.method.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		
//		Logistics road = new RoadLogistics();
		Logistics road = new SeaLogistics();
		Transport p = road.createLogistics();
		
		System.out.println(p);
		
		p.delivery("奔驰轿车");
	}

}

