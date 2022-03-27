package com.skycloud.refactor.chainofresp;

import org.junit.Test;



public class TomcatChainOfResponTest {

	@Test
	public void testFilter(){
//		ContextConfig config = new ContextConfig();
//		StandardWrapper value = new StandardWrapper();
		
		String msg = "大家好 Fuck you";//以下三行模拟一个请求
        MyRequest request = new MyRequest(msg);

        MyResponse response = new MyResponse();//响应

        FilterMyChain fc = new FilterMyChain();//过滤器链
        HtmlFilter f1 = new HtmlFilter();//创建过滤器
        SensitiveFilter f2 = new SensitiveFilter();//创建过滤器
       
        fc.addFilter(f1);//把过滤器添加到过滤器链中
        fc.addFilter(f2);
        fc.doFilter(request, response, fc);//直接调用过滤器链的doFilter()方法进行处理
	}
	
}
