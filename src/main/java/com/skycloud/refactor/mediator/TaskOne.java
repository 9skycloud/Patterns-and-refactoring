package com.skycloud.refactor.mediator;

import java.util.TimerTask;

public class TaskOne extends TimerTask {
    private static int num = 0;
    @Override
    public void run() {
        System.out.println("I'm TaskOne " + ++num);
    }
}
