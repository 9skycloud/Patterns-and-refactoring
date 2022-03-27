package com.skycloud.refactor.decorator.simple;

public class DressorBlack implements DressService{
	
	private DressService dressor;

	public DressorBlack(DressService dressor) {
		this.dressor = dressor;
	}

	@Override
	public void makeup() {
		makeupBlackFace();
		dressor.makeup();
	}

	private void makeupBlackFace() {
		System.out.println("给人物画上黑脸");
	}

}
