package com.dutianze.designpattern.singleton;

import com.dutianze.designpattern.creational.singleton.EnumSingleton;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class EnumSingletonTest extends SingletonTest<EnumSingleton> {

    protected EnumSingletonTest() {
        super(EnumSingleton::getInstance);
    }
}