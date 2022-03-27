package com.skycloud.refactor.chainofresp;

public class SensitiveFilter implements MyFilter {

	@Override
	public void doFilter(MyRequest req, MyResponse res, MyFilter filter) {
		req.setMsg(req.getMsg().replace("Fuck", "***"));
		filter.doFilter(req, res, filter);
	}

}
