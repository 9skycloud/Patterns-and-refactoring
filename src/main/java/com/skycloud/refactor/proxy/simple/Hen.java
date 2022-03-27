package com.skycloud.refactor.proxy.simple;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Hen implements HenService {

	private Egg egg;
	
	public Hen(){
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.proxy.simple.HenService#layEgg()
	 */
	@Override
	public void layEgg(){
		setEgg(new Egg(new Random().nextLong()+"","农家土鸡蛋","3CM*4CM",1));
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.proxy.simple.HenService#buyEgg()
	 */
	@Override
	public List<Egg> buyEgg(){
		return Lists.newArrayList(getEgg());
	}

	public Egg getEgg() {
		return egg;
	}

	public void setEgg(Egg egg) {
		this.egg = egg;
	}
	
}

