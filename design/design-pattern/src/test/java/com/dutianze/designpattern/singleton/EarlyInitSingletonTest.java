package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class EarlyInitSingletonTest extends SingletonTest<EarlyInitSingleton> {

    protected EarlyInitSingletonTest() {
        super(EarlyInitSingleton::getInstance);
    }
}