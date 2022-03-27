package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class PlayfullState implements StateService {

	@Override
	public void play(ContextBookMan book) {
		System.out.println("受到伤害");
		book.setState(new WrongedState());
	}

	@Override
	public String getStringState() {
		return "可爱";
	}

}

