package com.skycloud.refactor.creative.factory.method.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Ship implements Transport {

	private String shipNo;
	
	private String color;
	
	private long from;
	
	private long to;
	
	private String master;
	
	public Ship(String shipNo, long from, long to, String master) {
		this.shipNo = shipNo;
		this.from = from;
		this.to = to;
		this.master = master;
	}



	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.factory.method.simple.Transport#delivery(java.lang.String)
	 */
	@Override
	public void delivery(String something){
		System.out.println("轮船运输："+something);
	}



	@Override
	public String toString() {
		return "Ship [shipNo=" + shipNo + ", color=" + color + ", from=" + from
				+ ", to=" + to + ", master=" + master + "]";
	}
	
	
}

