package com.skycloud.refactor.mediator.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class MidiatorService {
	private ColleagueService northDriver;
	private ColleagueService southDriver;
	private ColleagueService westDriver;
	private ColleagueService eastDriver;
	
	
	public void runLeft(ColleagueService service,String msg){
		if(service instanceof EastDriver){
			//需要让左右(南北)两边，还有对面（西面）的车停下来
			northDriver.stop();
			southDriver.stop();
			westDriver.stop();
			System.out.println(msg);
		}else if(service instanceof WestDriver){
			
		}else if(service instanceof SouthDriver){
			
		}else if(service instanceof NorthDriver){
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.mediator.simple.ColleagueService#runAhead()
	 */
	public void runAhead(ColleagueService service,String msg){
		
		if(service instanceof EastDriver){
			//需要左右两边的车停下来
			northDriver.stop();
			southDriver.stop();
			System.out.println(msg);
		}else if(service instanceof WestDriver){
			
		}else if(service instanceof SouthDriver){
			
		}else if(service instanceof NorthDriver){
			
		}
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

	public void setEastDriver(ColleagueService eastDriver) {
		this.eastDriver = eastDriver;
	}
	
	
}

