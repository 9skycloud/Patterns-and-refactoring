package com.skycloud.refactor.adapter.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class ProAdapterTV implements TVService{
	
	private Projector pro;

	public ProAdapterTV(Projector pro) {
		this.pro = pro;
	}

	@Override
	public void play(CableProgram program) {
		pro.show(new String(program.getProgramValue()));
	}

}

