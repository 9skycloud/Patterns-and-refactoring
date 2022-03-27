package com.skycloud.refactor.creative.factory.method.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class SeaLogistics extends Logistics{

	public Transport createLogistics(){
		return new Ship("鲁Q.99999",129,56,"王五");
	}
}

