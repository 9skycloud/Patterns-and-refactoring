package com.skycloud.refactor.interpreter.before;

import java.awt.Color;
import java.util.List;

import com.skycloud.refactor.interpreter.old.Product;


public class BeforeMain {

	public static void main(String[] args) {
		ProductFinder finder = new ProductFinder();
		
//		List<Product> list = finder.belowPrice(30);
//		List<Product> list = finder.belowPriceAvoidingColor(30, Color.blue);
//		List<Product> list = finder.byColor(Color.blue);
//		List<Product> list = finder.byColorAndBelowPrice(50, Color.black);
		List<Product> list = finder.ByColorSizeAndBelowPrice(70, 15, Color.blue);
//		List<Product> list = finder.byPrice(9);
//		List<Product> list = finder.bySize(15);
		
		for(int i=0;i<list.size();i++){
			Product p = list.get(i);
			System.out.println("名称："+p.getName());
		}
	}

}
