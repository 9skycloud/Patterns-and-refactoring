package com.skycloud.refactor.bridge.simple.v3;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class DevelopImplementV1 implements ImplementService {
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementPage()
	 */
	@Override
	public void implementPage(){
		System.out.print("技术：用asp实现。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementBusiness()
	 */
	@Override
	public void implementBusiness(){
		System.out.print("技术：用vb实现。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementDataSave()
	 */
	@Override
	public void implementDataSave(){
		System.out.print("技术：使用access数据库存储。");
		System.out.println("");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.bridge.simple.v3.ImplementService#implementDataReport()
	 */
	@Override
	public void implementDataReport(){
		System.out.print("技术：使用sql语句查询分析统计");
		System.out.println("");
	}
}

