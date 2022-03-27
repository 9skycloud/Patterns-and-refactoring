package com.skycloud.refactor.visitor.simple;

public class Biologist implements AbstractVisitor{

	@Override
	public void visit(Forest forest) {
		System.out.println("获取受访对象资源："+forest.report());
		System.out.println("得出《森林物种统计报告》");
	}

	@Override
	public void visit(GrassLand grass) {
		// TODO Auto-generated method stub
		System.out.println("获取受访对象资源："+grass.grassReport());
		System.out.println("得出《草木虫害报告》");
	}

	@Override
	public void visit(Pond pond) {
		// TODO Auto-generated method stub
		System.out.println("获取受访对象资源："+pond.report());
		System.out.println("得出《河水质量报告》");
	}

}
