package com.dutianze.designpattern.singleton;

import com.dutianze.designpattern.creational.singleton.DoubleCheckSingleton;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class DoubleCheckSingletonTest extends SingletonTest<DoubleCheckSingleton> {

    protected DoubleCheckSingletonTest() {
        super(DoubleCheckSingleton::getInstance);
    }

    @Test
    void creatingNewInstanceByRefection() throws Exception {
        DoubleCheckSingleton.getInstance();
        Constructor<DoubleCheckSingleton> constructor = DoubleCheckSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        assertThrows(InvocationTargetException.class, () -> constructor.newInstance((Object[]) null));
    }
}