package com.skycloud.refactor.command.old;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkshopRepository {
	
	private List<Workshop> list = new ArrayList<>();

	
	public void add(Workshop shop){
		list.add(shop);
	}
	
	
	public Iterator keyIterator() {
		return list.iterator();
		
	}

	public Workshop getWorkshop(String id) {
		for(Workshop shop : list){
			if(shop.getId().equals(id))
				return shop;
		}
		return null;
	}

}
