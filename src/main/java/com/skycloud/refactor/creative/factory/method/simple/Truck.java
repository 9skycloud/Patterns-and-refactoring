package com.skycloud.refactor.creative.factory.method.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Truck implements Transport{

	private String id;
	
	private String truckNo;
	
	private long from;
	
	private long to;
	
	private String driver;
	
	public Truck(String truckNo, long from, long to, String driver) {
		this.truckNo = truckNo;
		this.from = from;
		this.to = to;
		this.driver = driver;
	}



	public void delivery(String something){
		System.out.println("使用卡车运输:"+something);
	}



	@Override
	public String toString() {
		return "Truck [id=" + id + ", truckNo=" + truckNo + ", from=" + from
				+ ", to=" + to + ", driver=" + driver + "]";
	}
	
	
}

