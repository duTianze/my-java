package com.dutianze.designpattern.abstractfactory.kingdom.orc;

import com.dutianze.designpattern.abstractfactory.kingdom.Army;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class OrcArmy implements Army {

    @Override
    public String getDescription() {
        return "This is the orc army!";
    }
}
