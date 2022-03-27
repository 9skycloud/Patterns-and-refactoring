package com.skycloud.refactor.command.simple;

public class Main {

	public static void main(String[] args) {
		
		Cook cook = new Cook();
		AbstractCommand chickenCommand = new ChickenCommand(cook);
		AbstractCommand muttonCommand = new MuttonCommand(cook);
		Waiter waiter = new Waiter(muttonCommand);
		
		
		System.out.println("服务员开始登记菜单，发送做饭命令：");
		
		waiter.send();
	}

}
