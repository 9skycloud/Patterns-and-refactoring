package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class SurprisedState implements StateService {

	@Override
	public void play(ContextBookMan book) {
		System.out.println("遇见可爱的人");
		book.setState(new PlayfullState());
	}

	@Override
	public String getStringState() {
		return "惊讶";
	}

}

