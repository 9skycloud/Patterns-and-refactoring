package com.skycloud.refactor.creative.factory.method.latest;


public class XMLBuilderTest extends AbstractBuilderTest{
	
	public OutputBuilder createBuilder(String rootName){
		return new XMLBuilder(rootName);
	}

}
