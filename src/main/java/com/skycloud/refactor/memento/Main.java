package com.skycloud.refactor.memento;

public class Main {

	public static void main(String[] args) {
		PersonCareTaker taker = new PersonCareTaker();
		Person p= new Person("zhangsan","西服","红色");
		
		PersonMemento m = p.saveMemento();
		taker.add(m);
		
		p.setClothesColor("蓝色");
		PersonMemento m2 = p.saveMemento();
		taker.add(m2);
		
		p.setClothesColor("黑色");
		PersonMemento m3 = p.saveMemento();
		
		taker.add(m3);
		p.setClothesColor("绿色");
		System.out.println("当前："+p.toString());
		
		PersonMemento blueMemento = taker.getLast();
		p.restore(blueMemento);
		
		System.out.println("恢复后："+p.toString());
	}

}
