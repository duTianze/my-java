package com.dutianze.designpattern.others.saga.orchestration;

import com.dutianze.designpattern.others.saga.orchestration.common.Saga;
import com.dutianze.designpattern.others.saga.orchestration.common.SagaOrchestrator;
import com.dutianze.designpattern.others.saga.orchestration.common.ServiceDiscoveryService;
import com.dutianze.designpattern.others.saga.orchestration.impl.FlyBookingService;
import com.dutianze.designpattern.others.saga.orchestration.impl.HotelBookingService;
import com.dutianze.designpattern.others.saga.orchestration.impl.OrderService;
import com.dutianze.designpattern.others.saga.orchestration.impl.WithdrawMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
class OrchestrationChapterTest {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            SagaOrchestrator sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());

            Saga.Result goodOrder = sagaOrchestrator.execute("good_order");
            Saga.Result badOrder = sagaOrchestrator.execute("bad_order");
            Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

            log.info("orders: goodOrder is {}, badOrder is {},crashedOrder is {}", goodOrder, badOrder, crashedOrder);
        });
    }

    private static Saga newSaga() {
        return Saga.create()
                   .chapter("init an order")
                   .chapter("booking a Fly")
                   .chapter("booking a Hotel")
                   .chapter("withdrawing Money");
    }

    private static ServiceDiscoveryService serviceDiscovery() {
        return new ServiceDiscoveryService()
                .discover(new OrderService())
                .discover(new FlyBookingService())
                .discover(new HotelBookingService())
                .discover(new WithdrawMoneyService());
    }
}