package com.skycloud.refactor.creative.factory.method.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class RoadLogistics extends Logistics {
	
	public Transport createLogistics() {
		return new Truck("京A.883322",129,56,"张三");
	}
}

