package com.skycloud.refactor.chainofresp;

public interface MyFilter {

	public void doFilter(MyRequest req,MyResponse res,MyFilter filter);
	
}
