package com.skycloud.refactor.creative.factory.abs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		AbstractFactory factory = getFactory();
		System.out.println(factory.createCar());
		System.out.println(factory.createPlane());
		System.out.println(factory.createShip());
	}

	private static AbstractFactory getFactory() {
		Properties prop = new Properties();
		try {
			BufferedReader buffer = new BufferedReader(new FileReader("F://eclipsespace/refactorPattern/src/main/resources/config/config.properties"));
			prop.load(buffer);
			String key =  (String) prop.getProperty("project");
			if(key!=null)
			return instanceFactory(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static AbstractFactory instanceFactory(String key) {
		try {
			Class class0 = Class.forName(key);
			Constructor c = class0.getConstructor(new Class[0]);
			return (AbstractFactory) c.newInstance(new Object[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
