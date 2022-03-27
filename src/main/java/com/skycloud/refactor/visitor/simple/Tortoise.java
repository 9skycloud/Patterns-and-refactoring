package com.skycloud.refactor.visitor.simple;

public class Tortoise implements AbstractVisitor {

	@Override
	public void visit(Forest forest) {
		System.out.println("获取受访对象资源："+forest.getTree());
		System.out.println("建造小房子");
	}

	@Override
	public void visit(GrassLand grass) {
		System.out.println("获取受访对象资源："+grass.getGrass());
		System.out.println("造个小窝");
	}

	@Override
	public void visit(Pond pond) {
		System.out.println("获取受访对象资源："+pond.getWater());
		System.out.println("洗个澡");
	}

}
