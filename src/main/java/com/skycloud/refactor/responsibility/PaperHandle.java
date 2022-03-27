package com.skycloud.refactor.responsibility;

public class PaperHandle implements HandleService{
	
	private HandleService next;
	
	public PaperHandle(HandleService next) {
		this.next = next;
	}

	public void handle(String input){
		if(input.indexOf("废纸")>-1){
			String result = input.replace("废纸","");
			System.out.println("--------废纸拦截器拦截废纸------"+result);
			return;
		}else if(next !=null){
			next.handle(input);
		}
		System.out.println("不拦截："+input);
	}

}
