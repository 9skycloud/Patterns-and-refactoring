package com.skycloud.refactor.prototype.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	static Map<String,String> map = new HashMap<>();
	
	static{
		map.put("3212321@qq.com", "张三");
		map.put("5422333@qq.com", "李四");
		map.put("54264322@qq.com", "王五");
		map.put("45643323@qq.com", "赵六");
		map.put("973223433@qq.com", "杨七");
		map.put("1@qq.com", "杨1");
		map.put("2@qq.com", "杨2");
		map.put("3@qq.com", "杨3");
		map.put("4@qq.com", "杨4");
		map.put("5@qq.com", "杨5");
		map.put("6@qq.com", "杨6");
		map.put("7@qq.com", "杨7");
		map.put("8@qq.com", "杨8");
		map.put("9@qq.com", "杨9");
		map.put("10@qq.com", "杨10");
		map.put("11@qq.com", "杨11");
		map.put("12@qq.com", "杨12");
		map.put("13@qq.com", "杨13");
		map.put("14@qq.com", "杨14");
		map.put("15@qq.com", "杨15");
		map.put("16@qq.com", "杨16");
		map.put("17@qq.com", "杨17");
		map.put("18@qq.com", "杨18");
	}
	public static void main(String[] args) {
		
		Mail mail = new Mail("百万额度信用卡待激活","XX银行推出百万额度信用卡，只需填写简单资料便能激活","xx银行信用卡中心");
		ExecutorService executor = Executors.newFixedThreadPool(100);
		for(String key:map.keySet()){
			executor.execute(new Runnable(){
				@Override
				public void run() {
					Mail mailClone = mail.clone();
					mailClone.setReceiver(key);
					mailClone.setAppellation(map.get(key)+"先生/女士");
					sendMail(mailClone);
				}
				
			});
		}
		
		executor.shutdown();
		

		
	}

	private static void sendMail(Mail mail) {
		System.out.println("邮件已发送："+mail.getReceiver() +","+mail.getAppellation()+","+mail.getSubject()+","+mail.getContent()+","+mail.getTail());
	}

}

