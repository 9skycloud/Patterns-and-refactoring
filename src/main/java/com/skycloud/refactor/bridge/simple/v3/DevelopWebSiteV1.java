package com.skycloud.refactor.bridge.simple.v3;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class DevelopWebSiteV1 implements BusinessService {
	
	private ImplementService developImplement;

	public DevelopWebSiteV1(ImplementService developImplement) {
		this.developImplement = developImplement;
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.BusinessService#developPage()
	 */
	@Override
	public void developPage(){
		System.out.print("业务：界面开发;");
		developImplement.implementPage();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.BusinessService#developBusiness()
	 */
	@Override
	public void developBusiness(){
		System.out.print("业务：业务功能开发;");
		developImplement.implementBusiness();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.BusinessService#developDataSave()
	 */
	@Override
	public void developDataSave(){
		System.out.print("业务：数据存储开发;");
		developImplement.implementDataSave();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.BusinessService#developDataReport()
	 */
	@Override
	public void developDataReport(){
		System.out.print("业务：数据分析开发");
		developImplement.implementDataReport();
	}
}

