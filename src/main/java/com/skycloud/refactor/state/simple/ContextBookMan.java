package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class ContextBookMan {

	private StateService state;
	
	StringBuffer sb = new StringBuffer();
	public ContextBookMan(StateService state){
		this.state = state;
	}
	
	public void play(){
		if(sb.length()>0){
			System.out.print(" 继续 ");
		}else{
			sb.append(" 玩耍 ");
			System.out.println("我很【"+state.getStringState()+"】");
		}
		System.out.println(sb.toString());
		state.play(this);
		System.out.println("当前，我变得很【"+state.getStringState()+"】");
	}

	public void setState(StateService state) {
		this.state = state;
	}
	
}

