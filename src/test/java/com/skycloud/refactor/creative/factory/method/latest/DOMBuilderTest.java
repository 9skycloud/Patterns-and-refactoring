package com.skycloud.refactor.creative.factory.method.latest;

public class DOMBuilderTest extends AbstractBuilderTest{
	
	
	public OutputBuilder createBuilder(String rootName){
		return new DOMBuilder(rootName);
	}

	
}
