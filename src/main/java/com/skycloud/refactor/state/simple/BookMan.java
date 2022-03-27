package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class BookMan {

	private String state;
	
	StringBuffer sb = new StringBuffer();
	public BookMan(){
		this.state = "happy";
	}
	
	public void play(){
		if(sb.length()>0){
			System.out.print(" 继续 ");
		}else{
			sb.append(" 玩耍 ");
			System.out.println("我很"+state);
		}
		System.out.println(sb.toString());
		
		if(state == "wronged"){
			state ="happy";
		}else if(state == "happy"){
			System.out.println("好大的地方!");
			state = "surprised";
		}else if(state == "surprised"){
			System.out.println("遇见可爱的人");
			state = "playfull";
		}else if(state == "playfull"){
			System.out.println("受到伤害");
			state = "wronged";
		}
		System.out.println("当前，我变得很"+state);
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

