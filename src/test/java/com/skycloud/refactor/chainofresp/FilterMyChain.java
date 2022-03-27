package com.skycloud.refactor.chainofresp;

import java.util.ArrayList;
import java.util.List;

public class FilterMyChain implements MyFilter{
	
	private int index;
	
	private List<MyFilter> list = new ArrayList<MyFilter>();

	@Override
	public void doFilter(MyRequest req, MyResponse res, MyFilter filter) {
		if(index == list.size())
			return;
		MyFilter myFilter = list.get(index);
		index++;
		myFilter.doFilter(req, res, filter);
	}
	
	public void addFilter(MyFilter filter){
		list.add(filter);
	}

}
