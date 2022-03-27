package com.skycloud.refactor.facade.simple;

public class MainA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSystemFacade facade = new SubSystemFacade();
		facade.getSystemA().methodA();
		facade.getSystemB().methodB();
		facade.getSystemC().methodA();
	}

}
