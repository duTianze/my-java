package com.dutianze.designpattern.others.saga.choreography.impl;

import com.dutianze.designpattern.others.saga.choreography.common.ServiceDiscoveryService;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class OrderService extends Service {

    public OrderService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "init an order";
    }
}
