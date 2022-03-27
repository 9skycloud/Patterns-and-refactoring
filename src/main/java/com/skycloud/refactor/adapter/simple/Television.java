package com.skycloud.refactor.adapter.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Television implements TVService {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.adapter.simple.TVService#play(com.skycloud.refactor.adapter.simple.CableProgram)
	 */
	@Override
	public void play(CableProgram program){
		System.out.println("电视播放："+getProgram(program));
	}
	
	public String getProgram(CableProgram p){
		StringBuffer sb = new StringBuffer();
		sb.append("电视台："+p.getProgramName());
		sb.append("频道："+p.getProgramNo());
		sb.append("节目信息："+new String(p.getProgramValue()));
		
		return sb.toString();
	}
}

