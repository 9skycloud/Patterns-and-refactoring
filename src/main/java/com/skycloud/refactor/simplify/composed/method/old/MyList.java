package com.skycloud.refactor.simplify.composed.method.old;


public class MyList {
	
	private boolean readOnly=false;
	private Object[] elements = new Object[10];
	
	private final static int GROWTH_INCREMENT=10;
	
	private int index;
	
	/**
	 * 改造之前
	 * @param element
	 */
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
	
	/**
	 * 改造之后
	 * @param element
	 */
	public void add1(Object element){
//		使用卫子句是更好的选择，可以为方法申明一个提前出口
		if(readOnly)
			return;
		if(atCapacity())
			grow();
		addElement(element);	
	}
//	条件判断提炼为函数
	public boolean atCapacity(){
		return (index+1)>elements.length;
	}
	
//	扩大数组长度的代码提炼函数
	public void grow(){
//		魔数10表示的非常不好，修改为常量
		Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
		for(int i=0;i<index;i++){
			newElements[i]=elements[i];
		}
		elements = newElements;
	}
	
//	一行代码，和其他函数保持在细节的同一个层面上
	public void addElement(Object element){
		elements[index++]=element;
	}

}
