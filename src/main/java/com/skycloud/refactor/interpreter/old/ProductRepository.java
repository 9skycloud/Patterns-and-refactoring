package com.skycloud.refactor.interpreter.old;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {
	
	public Iterator iterator() {
		// String name, Color color, float price, int size
		Product p1 = new Product("product1", Color.red, 9, 10);
		Product p2 = new Product("product2", Color.blue, 20, 10);
		Product p3 = new Product("product3", Color.BLACK, 30, 12);
		Product p4 = new Product("product4", Color.blue, 40, 12);
		Product p5 = new Product("product5", Color.green, 50, 15);
		Product p9 = new Product("product5", Color.green, 48, 15);
		Product p6 = new Product("product6", Color.blue, 60, 15);
		Product p7 = new Product("product7", Color.blue, 70, 15);
		Product p8 = new Product("product8", Color.blue, 80, 12);
		List list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		list.add(p9);

		return list.iterator();
	}

}
