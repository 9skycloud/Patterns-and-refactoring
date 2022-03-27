package com.skycloud.refactor.proxy.simple;

import java.util.List;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("*************从母鸡处直接购买鸡蛋*************");
		Hen hen = new Hen();
		System.out.println("让母鸡下蛋：");
		hen.layEgg();
		System.out.println("购买母鸡蛋：");
		System.out.println(hen.buyEgg());
	
		System.out.println("*****************从狐狸处购买鸡蛋*****************");
		FoxProxy proxy = new FoxProxy(hen);
		
		List<Egg> list = proxy.buyEgg();
		System.out.println("鸡蛋已购买到：");
		for(Egg e:list){
			System.out.println(e);
		}
	}

}

