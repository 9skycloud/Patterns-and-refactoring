package com.skycloud.refactor.memento;

public class PersonMemento {

	private String userName;
	
	private String clothes;
	
	private String clothesColor;

	public PersonMemento(String userName, String clothes, String clothesColor) {
		this.userName = userName;
		this.clothes = clothes;
		this.clothesColor = clothesColor;
	}

	public String getUserName() {
		return userName;
	}

	public String getClothes() {
		return clothes;
	}

	public String getClothesColor() {
		return clothesColor;
	}
	
	
	
}
