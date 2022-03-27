package com.skycloud.refactor.decorator.simple;

public class DressorRed implements DressService{
	
	private DressService dressor;

	public DressorRed(DressService dressor) {
		this.dressor = dressor;
	}

	@Override
	public void makeup() {
		makeupRedFace();
		dressor.makeup();
	}

	private void makeupRedFace() {
		System.out.println("给人物画上红脸");
	}

}
