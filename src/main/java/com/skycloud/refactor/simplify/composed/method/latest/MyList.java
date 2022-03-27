package com.skycloud.refactor.simplify.composed.method.latest;


public class MyList {
	
	private boolean readOnly=false;
	private Object[] elements = new Object[10];
	
	private int index;
	
	
	public void add(Object element){
		if(!readOnly){
			int newSize = index +1;
			if(newSize > elements.length){
				Object[] newElements = new Object[elements.length + 10];
				for(int i=0;i<index;i++){
					newElements[i]=elements[i];
				}
				elements = newElements;
			}
			elements[index++]=element;
		}
		
	}

}
