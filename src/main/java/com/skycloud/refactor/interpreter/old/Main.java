package com.skycloud.refactor.interpreter.old;

import java.awt.Color;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
//		ProductFinder finder = new ProductFinder();
//		
//		List<Product> list = finder.belowPrice(50);
//		System.out.println(list.toString());
		
//		ProductFinder2 find2 = new ProductFinder2();
//		List<Product> list = find2.belowPrice(50);
//		System.out.println(list.toString());
		
		
		ProductFinder2 find2 = new ProductFinder2();
		List<Product> list = find2.belowPriceAvoidingColor(50, Color.red);
		System.out.println(list.toString());
		
//		List<Product> list1 = find2.ByColorSizeAndBelowPrice(50,15, Color.green);
//		System.out.println(list1.toString());
	}

}
