package com.skycloud.refactor.creative.single;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class CallNumCenter {
	
	private CallNumCenter(){
		
	}
	
	private static CallNumCenter center = new CallNumCenter();

	private Integer lastNumber = 0;
	
	private final static Integer MAX_NUM= 10000; 
	
	private List<Integer> list = new LinkedList<>();
	
	public synchronized void generateNewNum(){
		if(lastNumber<MAX_NUM)
			lastNumber++;
		else
			lastNumber = 1;
		list.add(lastNumber);
	}
	
	public synchronized Integer getNum(){
		if(list.size()>0)
			return list.remove(0);
		else
			return null;
	}
	
	public static CallNumCenter instance(){
		return center;
	}
	
}

