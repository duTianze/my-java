package com.dutianze.designpattern.others.throttling.timer;

import lombok.RequiredArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@RequiredArgsConstructor
public class ThrottleTimerImpl implements Throttler {

    private final int throttlePeriod;
    private final CallsCount callsCount;

    @Override
    public void start() {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                callsCount.reset();
            }
        }, 0, throttlePeriod);
    }
}
