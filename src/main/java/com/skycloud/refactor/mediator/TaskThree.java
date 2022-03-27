package com.skycloud.refactor.mediator;

import java.util.TimerTask;

public class TaskThree extends TimerTask {
    private static int num = 1000;
    @Override
    public void run() {
        System.out.println("I'm TaskThree " + num--);
    }
}
