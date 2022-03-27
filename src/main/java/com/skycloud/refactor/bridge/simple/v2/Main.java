package com.skycloud.refactor.bridge.simple.v2;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DevelopWebSite webSite = new DevelopWebSite();
//		webSite.develop();
		
		System.out.println("使用桥接后：");
		DevelopImplement impl = new DevelopImplement();
		DevelopWebSite webSite = new DevelopWebSite(impl);
		
		webSite.developPage();
		webSite.developBusiness();
		webSite.developDataSave();
		webSite.developDataReport();
	}

}

