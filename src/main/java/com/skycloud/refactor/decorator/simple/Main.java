package com.skycloud.refactor.decorator.simple;

public class Main {

	public static void main(String[] args) {
		Actor actor = new Actor(); 
		DressorBlack black = new DressorBlack(actor);
		DressorBlue blue = new DressorBlue(black);
		DressorGreen green = new DressorGreen(blue);
		DressorRed red = new DressorRed(green);
		
		red.makeup();
	}

}
