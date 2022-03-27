package com.skycloud.refactor.proxy.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 * 狐狸代理
 */
public class FoxProxy implements HenService {
	
	//一篮子鸡蛋
	private List<Egg> list = new ArrayList<>();

	//下蛋母鸡
	private Hen hen;
	
	public FoxProxy(Hen hen) {
		this.hen = hen;
		layEgg();
	}

	@Override
	public void layEgg() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				hen.layEgg();
				list.addAll(hen.buyEgg());
				if(list.size()==30)
					timer.cancel();
			}
		}, 0, 1000);
	}

	@Override
	public List<Egg> buyEgg() {
		while(list.size()!=30){
			try {
				System.out.println("鸡蛋储备不足，请稍等，母鸡正在努力的下蛋中......");
				Thread.sleep(1000);
				continue;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}

