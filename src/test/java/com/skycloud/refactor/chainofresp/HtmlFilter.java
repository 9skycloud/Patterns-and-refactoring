package com.skycloud.refactor.chainofresp;

public class HtmlFilter implements MyFilter {

	@Override
	public void doFilter(MyRequest req, MyResponse res, MyFilter filter) {
		System.out.println("html处理");
		filter.doFilter(req, res, filter);
	}

}
