package com.skycloud.refactor.decorator.simple;

public class Actor implements DressService {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.decorator.simple.DressService#makeup()
	 */
	@Override
	public void makeup(){
		System.out.println("演员本色");
	}
	
}
