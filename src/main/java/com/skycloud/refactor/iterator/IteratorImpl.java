package com.skycloud.refactor.iterator;

import java.util.List;

public class IteratorImpl implements IteratorService {

	private List<Apple> list;
	
	private int index = 0;
	
	public IteratorImpl(List<Apple> list) {
		this.list = list;
	}

	@Override
	public Apple next() {
		return list.get(index++);
	}

	@Override
	public boolean hasMore() {
		if(index<list.size())
			return true;
		return false;
	}

}
