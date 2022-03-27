package com.skycloud.refactor.creative.factory.abs;

public class BusinessFactory implements AbstractFactory{

	@Override
	public CarService createCar() {
		return new BusinessCar();
	}

	@Override
	public PlaneService createPlane() {
		return new BusinessPlane();
	}

	@Override
	public ShipService createShip() {
		return new BusinessShip();
	}

}
