package com.skycloud.refactor.creative.single;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Customer implements Runnable{
	
	private int index;
	
	public Customer(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		
		CallNumCenter center = CallNumCenter.instance();
		center.generateNewNum();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

