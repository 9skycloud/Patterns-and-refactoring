package com.skycloud.refactor.proxy.simple;

import java.util.List;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public interface HenService {

	/**
	 * 母鸡下蛋
	 */
	public abstract void layEgg();

	/**
	 * 购买鸡蛋
	 * @return
	 */
	public abstract List<Egg> buyEgg();

}
