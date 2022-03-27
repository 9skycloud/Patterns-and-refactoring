package com.skycloud.refactor.memento;

public class Person {
	
	private String userName;
	
	private String clothes;
	
	private String clothesColor;
	
	
	public Person(String userName, String clothes, String clothesColor) {
		this.userName = userName;
		this.clothes = clothes;
		this.clothesColor = clothesColor;
	}

	public PersonMemento saveMemento(){
		return new PersonMemento(userName,clothes,clothesColor);
	}
	
	public void restore(PersonMemento m){
		this.userName = m.getUserName();
		this.clothes = m.getClothes();
		this.clothesColor = m.getClothesColor();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClothes() {
		return clothes;
	}

	public void setClothes(String clothes) {
		this.clothes = clothes;
	}

	public String getClothesColor() {
		return clothesColor;
	}

	public void setClothesColor(String clothesColor) {
		this.clothesColor = clothesColor;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", clothes=" + clothes
				+ ", clothesColor=" + clothesColor + "]";
	}

}
