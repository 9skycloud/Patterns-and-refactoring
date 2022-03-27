package com.skycloud.refactor.creative.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		ExecutorService customerService = Executors.newFixedThreadPool(20);
		
		for(int i=0;i<30;i++){
			customerService.execute(new Customer(i+1));
		}
		ExecutorService counterService = Executors.newFixedThreadPool(20);
		for(int i=0;i<4;i++){
			customerService.execute(new Counter(i+1));
		}
	}

}

