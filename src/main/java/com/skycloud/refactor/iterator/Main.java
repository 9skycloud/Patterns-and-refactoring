package com.skycloud.refactor.iterator;

public class Main {

	public static void main(String[] args) {
		Apple a1 = new Apple("红富士1",12,"水果");
		Apple a2 = new Apple("红富士2",12,"水果");
		Apple a3 = new Apple("红富士3",12,"水果");
		Apple a4 = new Apple("红富士4",12,"水果");
		Apple a5 = new Apple("红富士5",12,"水果");
		Apple a6 = new Apple("红富士6",12,"水果");
		
		AppleContainer container = new AppleContainer();
		container.add(a1);
		container.add(a2);
		container.add(a3);
		container.add(a4);
		container.add(a5);
		container.add(a6);
		
		IteratorService iterator = container.createIterator();
		
		while(iterator.hasMore()){
			Apple temp = iterator.next();
			System.out.println(temp);
		}
		
	}

}
