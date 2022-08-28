package com.dutianze.designpattern.others.saga.choreography.impl;

import com.dutianze.designpattern.others.saga.choreography.common.Saga;
import com.dutianze.designpattern.others.saga.choreography.common.ServiceDiscoveryService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class WithdrawMoneyService extends Service {

    public WithdrawMoneyService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "withdrawing Money";
    }

    @Override
    public Saga process(Saga saga) {
        Object inValue = saga.getCurrentValue();

        if (inValue.equals("bad_order")) {
            log.info("The chapter '{}' has been started. But the exception has been raised."
                     + "The rollback is about to start {}", getName(), inValue);
            saga.setCurrentStatus(Saga.ChapterResult.ROLLBACK);
            return saga;
        }
        return super.process(saga);
    }
}
