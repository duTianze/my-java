package com.dutianze.designpattern.others.saga.orchestration.impl;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class FlyBookingService extends Service<String> {

    @Override
    public String getName() {
        return "booking a Fly";
    }
}
