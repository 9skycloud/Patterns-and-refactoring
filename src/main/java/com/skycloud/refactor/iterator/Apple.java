package com.skycloud.refactor.iterator;

public class Apple {

	private String name;
	
	private int size;
	
	private String type;

	public Apple(String name, int size, String type) {
		this.name = name;
		this.size = size;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Apple [name=" + name + ", size=" + size + ", type=" + type
				+ "]";
	}
	
	
	
}
