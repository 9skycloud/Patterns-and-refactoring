package com.skycloud.refactor.command.simple;

public class ChickenCommand implements AbstractCommand {

	private Cook cook;

	public ChickenCommand(Cook cook) {
		this.cook = cook;
	}
	
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.command.simple.AbstractCommand#send()
	 */
	@Override
	public void execute(){
		cook.cookChickenWings();
	}
	
	
}
