package com.skycloud.refactor.facade;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

import sun.misc.Service;

public class Main {

	public static void main(String[] args) {
		DriverManager m = null;
		Iterator<IUser> providers = Service.providers(IUser.class);
        ServiceLoader<IUser> load = ServiceLoader.load(IUser.class);
        while(providers.hasNext()) {
        	IUser ser = providers.next();
            ser.execute();
        }
        System.out.println("--------------------------------");
        Iterator<IUser> iterator = load.iterator();
        while(iterator.hasNext()) {
        	IUser ser = iterator.next();
            ser.execute();
        }
	}

}
