package com.skycloud.refactor.command.old;

public class HandlerResponse {
	
	private String data;
	
	private String key;

	public HandlerResponse(StringBuffer stringBuffer,
			String allWorkshopStylesheet) {
		this.data = stringBuffer.toString();
		key = allWorkshopStylesheet;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
