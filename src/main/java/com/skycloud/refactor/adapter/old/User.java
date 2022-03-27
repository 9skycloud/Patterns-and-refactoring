package com.skycloud.refactor.adapter.old;

public class User {

	private String id;
	private String username;
	private String tel;
	private int age;
	private String address;
	
	public User(String id, String username, String tel, int age,
			String address) {
		this.id = id;
		this.username = username;
		this.tel = tel;
		this.age = age;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
