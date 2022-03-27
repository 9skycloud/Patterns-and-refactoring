package com.skycloud.refactor.visitor.simple;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<AbstractElement> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Biologist biologist=new Biologist();
		Tortoise tortoise = new Tortoise();
		
		Forest forest = new Forest();
		GrassLand grass = new GrassLand();
		Pond pond = new Pond();
		list.add(forest);
		list.add(pond);
		list.add(grass);
		
		System.out.println("乌龟访问：------------");
		for(AbstractElement e:list){
			e.accept(tortoise);
		}
		System.out.println("观察员访问：------------");
		for(AbstractElement e:list){
			e.accept(biologist);
		}
		
	}

}
