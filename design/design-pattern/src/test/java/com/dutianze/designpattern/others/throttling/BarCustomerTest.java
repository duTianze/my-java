package com.dutianze.designpattern.others.throttling;

import com.dutianze.designpattern.others.throttling.timer.ThrottleTimerImpl;
import com.dutianze.designpattern.others.throttling.timer.Throttler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Slf4j
class BarCustomerTest {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            CallsCount callsCount = new CallsCount();
            BarCustomer human = new BarCustomer("young human", 2, callsCount);
            BarCustomer dwarf = new BarCustomer("dwarf soldier", 4, callsCount);

            ExecutorService executorService = Executors.newFixedThreadPool(2);

            executorService.execute(() -> makeServiceCalls(human, callsCount));
            executorService.execute(() -> makeServiceCalls(dwarf, callsCount));

            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }

        });
    }

    private static void makeServiceCalls(BarCustomer barCustomer, CallsCount callsCount) {
        Throttler timer = new ThrottleTimerImpl(1000, callsCount);
        Bartender service = new Bartender(timer, callsCount);
        IntStream.range(0, 50).forEach(i -> {
            service.orderDrink(barCustomer);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("Thread interrupted: {}", e.getMessage());
            }
        });
    }
}