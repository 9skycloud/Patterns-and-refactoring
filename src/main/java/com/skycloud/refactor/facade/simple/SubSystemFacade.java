package com.skycloud.refactor.facade.simple;

public class SubSystemFacade {

	SubSystemModuleA systemA = new SubSystemModuleA();
	SubSystemModuleB systemB = new SubSystemModuleB();
	SubSystemModuleC systemC = new SubSystemModuleC();
	public SubSystemModuleA getSystemA() {
		return systemA;
	}
	public SubSystemModuleB getSystemB() {
		return systemB;
	}
	public SubSystemModuleC getSystemC() {
		return systemC;
	}
}
