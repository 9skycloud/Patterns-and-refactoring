package com.skycloud.refactor.creative.factory.abs;

public class AgriCar implements CarService {

	private String carNo;
	
	private String name;
	
	private String spec;
	
	private String color;

	@Override
	public String toString() {
		return "AgriCar [carNo=" + carNo + ", name=" + name + ", spec=" + spec
				+ ", color=" + color + "]";
	}
	
}
