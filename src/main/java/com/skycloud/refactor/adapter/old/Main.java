package com.skycloud.refactor.adapter.old;

import java.sql.Connection;
import java.sql.Driver;
import java.util.List;

import com.skycloud.refactor.adapter.latest.MapToListAdater;


public class Main {

	public static void main(String[] args) {
		
		UserService service = new UserService();
		List<User> list = service.getUsers();
		Connection conn = null;
		Driver driver = null;
//		
//		Map<String,Object> map  = new HashMap<>();
//		for(int i=0;i<list.size();i++){
//			map.put(i+"", list.get(i));
//		}
		
		ExportExcel export = new ExportExcel();
		export.export(new MapToListAdater(list));
		
	}
	

}
