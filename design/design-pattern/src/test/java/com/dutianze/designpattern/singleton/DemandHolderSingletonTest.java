package com.dutianze.designpattern.singleton;

import com.dutianze.designpattern.creational.singleton.DemandHolderSingleton;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class DemandHolderSingletonTest extends SingletonTest<DemandHolderSingleton> {

    protected DemandHolderSingletonTest() {
        super(DemandHolderSingleton::getInstance);
    }
}