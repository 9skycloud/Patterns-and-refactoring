package com.skycloud.refactor.log;

public class LogSay3 implements LogFac {

	@Override
	public String say() {
		System.out.println("say");
		return "say3";
	}

}
