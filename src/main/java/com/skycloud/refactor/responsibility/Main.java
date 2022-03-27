package com.skycloud.refactor.responsibility;

public class Main {

	public static void main(String[] args) {
		String[] strs = {"自说自话废纸","自说自话纸盒","自说自话，无需处理","自说自话蛋壳"};
		
		HandleService paperHandle = new PaperHandle(null);
		HandleService boxHandle = new BoxHandle(paperHandle);
		HandleService eggHandle = new EggHandle(boxHandle);
		
		for(String str:strs){
			eggHandle.handle(str);
		}
		
	}

}
