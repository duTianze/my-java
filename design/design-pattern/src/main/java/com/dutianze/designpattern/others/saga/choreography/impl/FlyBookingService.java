package com.dutianze.designpattern.others.saga.choreography.impl;

import com.dutianze.designpattern.others.saga.choreography.common.ServiceDiscoveryService;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class FlyBookingService extends Service {

    public FlyBookingService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "booking a Fly";
    }
}

