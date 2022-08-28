package com.dutianze.designpattern.others.saga.choreography;

import com.dutianze.designpattern.others.saga.choreography.ChoreographyChapter;
import com.dutianze.designpattern.others.saga.choreography.common.Saga;
import com.dutianze.designpattern.others.saga.choreography.common.ServiceDiscoveryService;
import com.dutianze.designpattern.others.saga.choreography.impl.FlyBookingService;
import com.dutianze.designpattern.others.saga.choreography.impl.HotelBookingService;
import com.dutianze.designpattern.others.saga.choreography.impl.OrderService;
import com.dutianze.designpattern.others.saga.choreography.impl.WithdrawMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
class ChoreographyChapterTest {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            ServiceDiscoveryService serviceDiscovery = serviceDiscovery();
            ChoreographyChapter service = serviceDiscovery.findAny();
            Saga goodOrderSaga = service.execute(newSaga("good_order"));
            Saga badOrderSaga = service.execute(newSaga("bad_order"));
            log.info("orders: goodOrder is {}, badOrder is {}", goodOrderSaga.getResult(), badOrderSaga.getResult());
        });
    }

    private static Saga newSaga(Object value) {
        return Saga.create()
                   .chapter("init an order").setInValue(value)
                   .chapter("booking a Fly")
                   .chapter("booking a Hotel")
                   .chapter("withdrawing Money");
    }

    private static ServiceDiscoveryService serviceDiscovery() {
        ServiceDiscoveryService sd = new ServiceDiscoveryService();
        return sd.discover(new OrderService(sd))
                 .discover(new FlyBookingService(sd))
                 .discover(new HotelBookingService(sd))
                 .discover(new WithdrawMoneyService(sd));
    }

}