package com.skycloud.refactor.decorator.simple;

public class DressorGreen implements DressService{
	
	private DressService dressor;

	public DressorGreen(DressService dressor) {
		this.dressor = dressor;
	}

	@Override
	public void makeup() {
		makeupGreenFace();
		dressor.makeup();
	}

	private void makeupGreenFace() {
		System.out.println("给人物画上绿脸");
	}

}
