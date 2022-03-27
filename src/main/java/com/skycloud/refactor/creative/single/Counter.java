package com.skycloud.refactor.creative.single;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Counter implements Runnable{

	private int count;
	
	public Counter(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		while(true){
			Integer myNum = CallNumCenter.instance().getNum();
			if(myNum == null){
				System.out.println("当前没有用户办理业务，等待中......");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println(count +"柜台办理"+myNum+"号业务");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

