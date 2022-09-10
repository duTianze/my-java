package com.dutianze.designpattern.structural.facade;

/**
 * 外观模式为一个复杂的子系统提供一个简单的接口
 *
 * @author dutianze
 * @date 2022/8/13
 */
public interface DwarvenGoldmineFacade {

    void startNewDay();

    void digOutGold();

    void endDay();
}