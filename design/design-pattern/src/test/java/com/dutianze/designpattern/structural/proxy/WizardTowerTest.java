package com.dutianze.designpattern.structural.proxy;

import com.dutianze.designpattern.structural.proxy.tower.WizardTower;
import com.dutianze.designpattern.structural.proxy.tower.impl.IvoryTower;
import com.dutianze.designpattern.structural.proxy.tower.impl.WizardTowerProxy;
import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class WizardTowerTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
            proxy.enter(new Wizard("Red wizard"));
            proxy.enter(new Wizard("White wizard"));
            proxy.enter(new Wizard("Black wizard"));
            proxy.enter(new Wizard("Green wizard"));
            proxy.enter(new Wizard("Brown wizard"));
        });
    }

    @Test
    void testEnter() {
        final List<Wizard> wizards =
                List.of(new Wizard("Gandalf"), new Wizard("Dumbledore"), new Wizard("Oz"), new Wizard("Merlin"));

        final WizardTower proxy = new WizardTowerProxy(new IvoryTower());
        wizards.forEach(proxy::enter);

        assertTrue(appender.logContains("Gandalf enters the tower."));
        assertTrue(appender.logContains("Dumbledore enters the tower."));
        assertTrue(appender.logContains("Oz enters the tower."));
        assertTrue(appender.logContains("Merlin is not allowed to enter!"));
        assertEquals(4, appender.getLogSize());
    }
}