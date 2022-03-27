package com.skycloud.refactor.bridge.simple.v2;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class DevelopWebSite {
	
	private DevelopImplement developImplement;

	public DevelopWebSite(DevelopImplement developImplement) {
		this.developImplement = developImplement;
	}

	public void developPage(){
		System.out.print("业务：界面开发;");
		developImplement.implementPage();
	}
	
	public void developBusiness(){
		System.out.print("业务：业务功能开发;");
		developImplement.implementBusiness();
	}
	
	public void developDataSave(){
		System.out.print("业务：数据存储开发;");
		developImplement.implementDataSave();
	}
	
	public void developDataReport(){
		System.out.print("业务：数据分析开发");
		developImplement.implementDataReport();
	}
}

