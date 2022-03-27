package com.skycloud.refactor.proxy;

import java.util.List;

import com.skycloud.refactor.proxy.pojo.User;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public interface UserMapper {
	
    List<User> select();

}

