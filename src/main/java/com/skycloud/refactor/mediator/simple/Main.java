package com.skycloud.refactor.mediator.simple;
/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		ColleagueService northDriver = new NorthDriver();
		ColleagueService southDriver = new SouthDriver();
		EastDriver eastDriver = new EastDriver();
		ColleagueService westDriver = new WestDriver();
		
		
		MidiatorService midiator = new MidiatorService();
		
		midiator.setNorthDriver(northDriver);
		midiator.setSouthDriver(southDriver);
		midiator.setWestDriver(westDriver);
		
		eastDriver.setMidiator(midiator);
		
		eastDriver.runLeft();
		
		eastDriver.runAhead();
		
		eastDriver.runRight();
		
	}

}

