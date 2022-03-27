package com.skycloud.refactor.log;

public class LogSay2 implements LogFac {

	@Override
	public String say() {
		System.out.println("say");
		return "say2";
	}

}
