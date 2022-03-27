package com.skycloud.refactor.adapter.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String msg="文案AAA";
		System.out.println("************投影播放************");
		Projector pro = new Projector();
		pro.show(msg);
		System.out.println("************电视播放************");
		CableProgram p = new CableProgram("1","CCTV","新闻联播".getBytes());
		
		Television tv = new Television();
		tv.play(p);
		
		System.out.println("************投影适配电视播放************");
		ProAdapterTV proAdapter = new ProAdapterTV(pro);
		proAdapter.play(p);
		
		
	}

}

