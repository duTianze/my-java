package com.dutianze.designpattern.others.specialcase;

import com.dutianze.designpattern.others.specialcase.domain.Db;
import com.dutianze.designpattern.others.specialcase.domain.MaintenanceLock;
import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import com.dutianze.designpattern.others.specialcase.impl.ApplicationServicesImpl;
import com.dutianze.designpattern.utils.InMemoryAppender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
class ApplicationServicesTest {

    private static ApplicationServices applicationServices;
    private static ReceiptViewModel receipt;

    @BeforeAll
    static void beforeAll() {
        Db.getInstance().seedUser("ignite1771", 1000.0);
        Db.getInstance().seedItem("computer", 800.0);
        Db.getInstance().seedItem("car", 20000.0);

        applicationServices = new ApplicationServicesImpl();
    }

    @BeforeEach
    public void beforeEach() {
        MaintenanceLock.getInstance().setLock(false);
    }

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            log.info("[REQUEST] User: " + "abc123" + " buy product: " + "tv");
            receipt = applicationServices.loggedInUserPurchase("abc123", "tv");
            receipt.show();

            log.info("[REQUEST] User: " + "abc123" + " buy product: " + "tv");
            receipt = applicationServices.loggedInUserPurchase("abc123", "tv");
            receipt.show();

            log.info("[REQUEST] User: " + "ignite1771" + " buy product: " + "tv");
            receipt = applicationServices.loggedInUserPurchase("ignite1771", "tv");
            receipt.show();

            log.info("[REQUEST] User: " + "ignite1771" + " buy product: " + "car");
            receipt = applicationServices.loggedInUserPurchase("ignite1771", "car");
            receipt.show();

            log.info("[REQUEST] User: " + "ignite1771" + " buy product: " + "computer");
            receipt = applicationServices.loggedInUserPurchase("ignite1771", "computer");
            receipt.show();
        });
    }

    @Test
    public void testDownForMaintenance() {
        InMemoryAppender inMemoryAppender = new InMemoryAppender();
        MaintenanceLock.getInstance().setLock(true);
        receipt = applicationServices.loggedInUserPurchase(null, null);
        receipt.show();

        assertTrue(inMemoryAppender.logContains("Down for maintenance"));
    }
}