package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class HappyState implements StateService{

	@Override
	public void play(ContextBookMan bookman) {
		System.out.println("好大的地方!");
		bookman.setState(new SurprisedState());
	}

	@Override
	public String getStringState() {
		return "高兴";
	}

}

