package com.skycloud.refactor.observer.simple;

import java.util.ArrayList;
import java.util.List;

public class WeatherMonitor {

	private List<ObserverService> list = new ArrayList<>();
	
	public void subscribe(ObserverService o){
		this.list.add(o);
	}
	
	public void unSubscribe(ObserverService o){
		if(this.list.contains(o)){
			this.list.remove(o);
		}
	}
	
	public void notifyAllObserver(String input){
		for(ObserverService o:list){
			o.fire(input);
		}
	}
	
}
