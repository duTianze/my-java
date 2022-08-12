package com.dutianze.designpattern.creational.abstractfactory.kingdom.orc;

import com.dutianze.designpattern.creational.abstractfactory.kingdom.King;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class OrcKing implements King {

    @Override
    public String getDescription() {
        return "This is the orc king!";
    }
}
