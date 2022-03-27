package com.skycloud.refactor.mediator;

import java.util.Timer;



public class Main {

	public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TaskOne(), 3000, 1000);
        timer.schedule(new TaskTwo(), 10000, 10000);
        timer.scheduleAtFixedRate(new TaskThree(), 5000, 5000);
	}

}
