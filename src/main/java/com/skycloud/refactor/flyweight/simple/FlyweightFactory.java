package com.skycloud.refactor.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class FlyweightFactory {

	private Map<String,SmallMan> maps = new HashMap<>();
	
	
	public void add(String tshirt,String appearance){
		maps.put(tshirt+appearance, new SmallMan(tshirt, appearance));
	}
	
	public SmallMan get(String tshirt,String appearance){
		if(!maps.containsKey(tshirt+appearance))
			maps.put(tshirt+appearance, new SmallMan(tshirt, appearance));
		return maps.get(tshirt+appearance);
	}
}

