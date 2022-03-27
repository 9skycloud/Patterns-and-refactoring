package com.skycloud.refactor.command.simple;

public class Waiter {

	private AbstractCommand command;

	public Waiter(AbstractCommand command) {
		this.command = command;
	}
	
	public Waiter() {
		// TODO Auto-generated constructor stub
	}

	public void send(){
		command.execute();
	}
	
}
