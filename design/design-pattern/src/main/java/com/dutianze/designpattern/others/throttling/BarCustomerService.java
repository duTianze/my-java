package com.dutianze.designpattern.others.throttling;

import com.dutianze.designpattern.others.throttling.model.BarCustomer;
import com.dutianze.designpattern.others.throttling.timer.CallsCount;
import com.dutianze.designpattern.others.throttling.timer.Throttler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Slf4j
public class BarCustomerService {

    private final CallsCount callsCount;

    public BarCustomerService(Throttler timer, CallsCount callsCount) {
        this.callsCount = callsCount;
        timer.start();
    }

    public int orderDrink(BarCustomer barCustomer) {
        String tenantName = barCustomer.getName();
        long count = callsCount.getCount(tenantName);
        if (count >= barCustomer.getAllowedCallsPerSecond()) {
            log.error("I'm sorry {}, you've had enough for today!", tenantName);
            return -1;
        }
        callsCount.incrementCount(tenantName);
        log.debug("Serving beer to {} : [{} consumed] ", barCustomer.getName(), count + 1);
        return getRandomCustomerId();
    }

    private int getRandomCustomerId() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }
}
