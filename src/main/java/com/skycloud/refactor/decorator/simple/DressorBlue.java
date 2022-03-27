package com.skycloud.refactor.decorator.simple;

public class DressorBlue implements DressService{
	
	private DressService dressor;

	public DressorBlue(DressService dressor) {
		this.dressor = dressor;
	}

	@Override
	public void makeup() {
		makeupBlueFace();
		dressor.makeup();
	}

	private void makeupBlueFace() {
		System.out.println("给人物画上蓝脸");
	}

}
