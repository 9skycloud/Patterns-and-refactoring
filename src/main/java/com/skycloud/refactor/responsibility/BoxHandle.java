package com.skycloud.refactor.responsibility;

public class BoxHandle implements HandleService{

	private HandleService next;
	
	public BoxHandle(HandleService next) {
		this.next = next;
	}

	@Override
	public void handle(String input) {
		if(input.indexOf("纸盒")>-1){
			String result = input.replace("纸盒","");
			System.out.println("--------纸盒拦截器拦截纸盒-------"+result);
		}else if(next!=null){
			next.handle(input);
		}
	}

}
