package com.skycloud.refactor.decorator.latest;

public class Translate {
	public static String decode(String str){
		return str.replace("&amp;", "&")
				.replace("&divide;", "÷")
				.replace("&lt;", "<")
				.replace("&rt;", ">");
	}
}
