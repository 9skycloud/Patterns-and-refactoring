package com.skycloud.refactor.creative.factory.abs;

public class BusinessShip implements ShipService {

	private String shipId;
	
	private String shipNo;
	
	private String size;
	
	private String type;

	@Override
	public String toString() {
		return "BusinessShip [shipId=" + shipId + ", shipNo=" + shipNo + ", size="
				+ size + ", type=" + type + "]";
	}
	
	
}
