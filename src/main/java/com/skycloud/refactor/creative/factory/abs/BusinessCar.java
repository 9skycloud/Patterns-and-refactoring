package com.skycloud.refactor.creative.factory.abs;

public class BusinessCar implements CarService{

	private String carNo;
	
	private String name;
	
	private String spec;
	
	private String color;

	@Override
	public String toString() {
		return "BusinessCar [carNo=" + carNo + ", name=" + name + ", spec=" + spec
				+ ", color=" + color + "]";
	}
	
}
