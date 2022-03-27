package com.skycloud.refactor.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestList {
	
	@Test
	public void testSynchronizeList(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		List<String> result = Collections.synchronizedList(list);
		System.out.println(result.size());
		System.out.println("结束");
	}

}
