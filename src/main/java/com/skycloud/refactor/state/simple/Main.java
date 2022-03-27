package com.skycloud.refactor.state.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		/*BookMan book = new BookMan();
		book.play();
		
		book.play();
		
		book.play();
		
		book.play();*/
		
		StateService state = new PlayfullState();
		ContextBookMan man = new ContextBookMan(state);
		
		man.play();
		
	}

}

