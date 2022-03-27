package com.skycloud.refactor.creative.factory.abs;

public class BusinessPlane implements PlaneService{

	private String planeId;
	
	private String planeNo;
	
	private String type;
	
	private String size;

	@Override
	public String toString() {
		return "BusinessPlane [planeId=" + planeId + ", planeNo=" + planeNo + ", type="
				+ type + ", size=" + size + "]";
	}
	
}
