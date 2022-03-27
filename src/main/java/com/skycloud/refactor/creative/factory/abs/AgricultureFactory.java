package com.skycloud.refactor.creative.factory.abs;

public class AgricultureFactory implements AbstractFactory {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.factory.abs.AbstractFactory#createCar()
	 */
	@Override
	public CarService createCar(){
		return new AgriCar();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.factory.abs.AbstractFactory#createPlane()
	 */
	@Override
	public PlaneService createPlane(){
		return new AgriPlane();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.factory.abs.AbstractFactory#createShip()
	 */
	@Override
	public ShipService createShip(){
		return new AgriShip();
	}
	
}
