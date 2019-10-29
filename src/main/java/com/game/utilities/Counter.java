package com.game.utilities;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Counter {
    private int seconds;
    private int delay = 1000;
    private int count = 0;
    private ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {

            count++;
            System.out.println(count);
            if (count == seconds) {
                count = 0;
            }
        }

    };
    private Timer timer = new Timer(delay, taskPerformer);

    public Counter(int seconds) {
        timer.start();
        this.seconds = seconds;
    }

    public Counter() {
        timer.start();
    }

    public void stopCounting() {
        timer.stop();
    }

    public int getCount() {
        return count;
    }

    public int stopAndGetCount() {
        int result = count;
        timer.stop();
        return result;
    }
}
