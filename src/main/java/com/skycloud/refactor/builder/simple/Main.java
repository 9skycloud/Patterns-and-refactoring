package com.skycloud.refactor.builder.simple;

public class Main {

	public static void main(String[] args) {
		AbstractRobotBuilder robot = new NewRobot();
//		AbstractRobotBuilder robot = new NewRobot();
		robot.makeHead();
		robot.makeBody();
		robot.makeLeg();
	}

}
