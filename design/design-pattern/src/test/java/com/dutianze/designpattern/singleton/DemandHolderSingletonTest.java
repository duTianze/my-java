package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class DemandHolderSingletonTest extends SingletonTest<DemandHolderSingleton> {

    protected DemandHolderSingletonTest() {
        super(DemandHolderSingleton::getInstance);
    }
}