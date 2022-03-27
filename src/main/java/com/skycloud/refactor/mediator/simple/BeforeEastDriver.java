package com.skycloud.refactor.mediator.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class BeforeEastDriver implements ColleagueService {
	
	private ColleagueService northDriver;
	private ColleagueService southDriver;
	private ColleagueService westDriver;
	

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runLeft()
	 */
	@Override
	public void runLeft(){
		//需要让左右(南北)两边，还有对面（西面）的车停下来
		northDriver.stop();
		southDriver.stop();
		westDriver.stop();
		System.out.println("东边的车向左转");
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runAhead()
	 */
	@Override
	public void runAhead(){
		//需要左右两边的车停下来
		northDriver.stop();
		southDriver.stop();
		System.out.println("东边的车直行");
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

	public void setNorthDriver(ColleagueService northDriver) {
		this.northDriver = northDriver;
	}

	public void setSouthDriver(ColleagueService southDriver) {
		this.southDriver = southDriver;
	}

	public void setWestDriver(ColleagueService westDriver) {
		this.westDriver = westDriver;
	}
	
}

