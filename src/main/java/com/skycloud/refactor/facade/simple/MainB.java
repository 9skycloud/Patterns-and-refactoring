package com.skycloud.refactor.facade.simple;

public class MainB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSystemFacade facade = new SubSystemFacade();
		
		facade.getSystemA().methodB();
		facade.getSystemB().methodA();
		facade.getSystemC().methodB();
	}

}
