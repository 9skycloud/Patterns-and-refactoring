package com.skycloud.refactor.memento;

import java.util.ArrayList;
import java.util.List;

public class PersonCareTaker {

	private List<PersonMemento> list = new ArrayList<>();
	
	public void add(PersonMemento e){
		this.list.add(e);
	}
	
	public PersonMemento getLast(){
		return this.list.get(list.size()-1);
	}
	
	public PersonMemento getLast(int x){
		return this.list.get(x);
	}
	
}
