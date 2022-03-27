package com.skycloud.refactor.mediator.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class EastDriver implements ColleagueService {
	
	private MidiatorService midiator;
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runLeft()
	 */
	@Override
	public void runLeft(){
		//需要让左右(南北)两边，还有对面（西面）的车停下来
		midiator.runLeft(this, "东边的车向左转");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runAhead()
	 */
	@Override
	public void runAhead(){
		//需要左右两边的车停下来
		midiator.runAhead(this, "东边的车直行");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runRight()
	 */
	@Override
	public void runRight(){
		//需要靠右行驶
		System.out.println("东边的车向右转");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("东边的车停止，--- 等待");
	}

	public void setMidiator(MidiatorService midiator) {
		this.midiator = midiator;
	}


	
}

