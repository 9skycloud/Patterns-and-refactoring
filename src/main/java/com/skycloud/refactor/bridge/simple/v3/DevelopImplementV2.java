package com.skycloud.refactor.bridge.simple.v3;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class DevelopImplementV2 implements ImplementService {
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementPage()
	 */
	@Override
	public void implementPage(){
		System.out.print("技术：用js,前后端分离实现。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementBusiness()
	 */
	@Override
	public void implementBusiness(){
		System.out.print("技术：用java微服务实现。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementDataSave()
	 */
	@Override
	public void implementDataSave(){
		System.out.print("技术：使用oracle数据库集群存储。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementDataReport()
	 */
	@Override
	public void implementDataReport(){
		System.out.print("技术：使用hadoop进行数据统计分析");
		System.out.println("");
	}
}

