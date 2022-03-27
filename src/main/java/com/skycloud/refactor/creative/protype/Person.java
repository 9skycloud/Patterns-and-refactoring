package com.skycloud.refactor.creative.protype;

import java.util.ArrayList;

public class Person implements Cloneable {

	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("zhangsan");
		list.add("wangwu");
		ArrayList<String> clone = (ArrayList<String>) list.clone();
		
		System.out.println(list);
		System.out.println(clone);
	}
	
}
