package com.skycloud.refactor.adapter.old;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list.add(new User("1","zhangsan1","13954683322",12,"北京市"));
		list.add(new User("2","zhangsan2","13954683322",12,"北京市"));
		list.add(new User("3","zhangsan3","13954683322",12,"北京市"));
		list.add(new User("4","zhangsan4","13954683322",12,"北京市"));
		list.add(new User("5","zhangsan5","13954683322",12,"北京市"));
		list.add(new User("6","zhangsan6","13954683322",12,"北京市"));
		return list;
	}
	
}
