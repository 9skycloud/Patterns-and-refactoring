package com.skycloud.refactor.command.old;

public class Workshop {
	
	private String id;
	
	private String name;
	
	private String status;
	
	private String durationAsString;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDurationAsString(String durationAsString) {
		this.durationAsString = durationAsString;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getDurationAsString() {
		return durationAsString;
	}


}
