package com.skycloud.refactor.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.skycloud.refactor.state.old.SystemAdmin;
import com.skycloud.refactor.state.old.SystemPermission;
import com.skycloud.refactor.state.old.SystemUser;

public class TestStates{

	private SystemPermission permission;
	SystemUser user = null;
	SystemAdmin admin;
	
	@Test
	public void testGrantedBy(){
		user = new SystemUser("1","lili");
		admin = new SystemAdmin("2","zhanglei");
		permission = new SystemPermission(user);
		System.out.println(user.getUserName()+" 注册");
		System.out.println("权限状态："+permission.state());
		permission.grantedBy(admin);
		System.out.println(user.getUserName() + " 直接授权成功 ？"+permission.isGranted());
		assertEquals("requested",permission.REQUESTED,permission.state());
		assertEquals("not granted",false,permission.isGranted());
		System.out.print(user.getUserName() + " 授权前");
		System.out.println("状态："+permission.state());
		permission.claimedBy(admin);
		System.out.print(user.getUserName() + " 发起授权,");
		System.out.println("状态："+permission.state());
		System.out.println("----------------------------------");
		System.out.println("管理员:"+admin.getUserName()+" 登录");
		System.out.println("授权前状态："+permission.state());
		permission.grantedBy(admin);
		System.out.println("状态："+permission.state());
		assertEquals("granted",permission.GRANTED,permission.state());
		assertEquals("granted",true,permission.isGranted());
	}
}
