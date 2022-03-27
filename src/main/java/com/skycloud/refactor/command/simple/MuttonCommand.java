package com.skycloud.refactor.command.simple;

public class MuttonCommand implements AbstractCommand{
	
	private Cook cook;
	
	public MuttonCommand(Cook cook) {
		this.cook = cook;
	}

	@Override
	public void execute() {
		cook.cookMuttonSlices();
	}

}
