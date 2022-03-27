package com.skycloud.refactor.adapter.old;

import java.util.Map;

public class ExportExcel {

	public void export(Map<String,Object> map){
		for(int i=0;i<map.size();i++){
			User user = (User)map.get(i+"");
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getTel());
			System.out.println(user.getAge());
			System.out.println(user.getAddress());
		}
	}
	
}
