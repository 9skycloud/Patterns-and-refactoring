package com.skycloud.refactor.simplify.composed.simple;

public class Main {

	public static void main(String[] args) {
		CompositeNode compsite = new CompositeNode();
		
		Egg egg= new Egg("1",15);
		Egg egg2= new Egg("2",15);
		Egg egg3= new Egg("3",15);
		Egg egg4= new Egg("4",15);
		Egg egg5= new Egg("5",15);
		Egg egg6= new Egg("6",14);
		Egg egg7= new Egg("7",14);
		Egg egg8= new Egg("8",14);
		egg.add(egg2);
		egg.add(egg3);
		egg.add(egg4);
		egg.add(egg5);
		egg.add(egg6);
		egg.add(egg7);
		egg.add(egg8);
		
		Ring ring = new Ring("21",42000);
		
		Washbason bason = new Washbason("31",10);
		
		compsite.add(egg);
		compsite.add(ring);
		compsite.add(bason);
		
		System.out.println("总价："+compsite.calculate());
	}

}
