package com.skycloud.refactor.responsibility;

public class EggHandle implements HandleService {
	
	private HandleService next;
	
	public EggHandle(HandleService next) {
		this.next = next;
	}

	@Override
	public void handle(String input) {
		if(input.indexOf("蛋壳")>-1){
			String result = input.replace("蛋壳","");
			System.out.println("--------蛋壳拦截器拦截蛋壳------"+result);
		}else if(next != null){
			next.handle(input);
		}
	}

}
