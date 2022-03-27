package com.skycloud.refactor.mediator.simple;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public interface ColleagueService {

	/**
	 * 左转
	 */
	public abstract void runLeft();
	/**
	 * 直行
	 */
	public abstract void runAhead();

	/**
	 * 右转
	 */
	public abstract void runRight();
	
	/**
	 * 停止
	 */
	public abstract void stop();

}
