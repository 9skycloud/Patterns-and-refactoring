package com.skycloud.refactor.creative.factory.abs;

public interface AbstractFactory {

	public abstract CarService createCar();

	public abstract PlaneService createPlane();

	public abstract ShipService createShip();

}