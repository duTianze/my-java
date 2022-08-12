package com.dutianze.designpattern.creational.singleton;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class EnumSingletonTest extends SingletonTest<EnumSingleton> {

    protected EnumSingletonTest() {
        super(EnumSingleton::getInstance);
    }
}