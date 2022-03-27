package com.skycloud.refactor.simplify.composed.simple;

import java.util.ArrayList;
import java.util.List;

public class CompositeNode implements CalculatePriceService{
	
	private List<CalculatePriceService> list = new ArrayList<>();

	@Override
	public float calculate() {
		float total = 0;
		for(CalculatePriceService service:list){
			float x = service.calculate();
			System.out.println(service.getClass().getSimpleName()+":"+x);
			total += x;
		}
		return total;
	}
	
	public void add(CalculatePriceService e){
		this.list.add(e);
	}
	
	public void remove(CalculatePriceService o){
		this.list.remove(o);
	}
	
	

}
