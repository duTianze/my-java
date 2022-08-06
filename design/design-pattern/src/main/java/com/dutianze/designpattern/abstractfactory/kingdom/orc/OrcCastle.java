package com.dutianze.designpattern.abstractfactory.kingdom.orc;

import com.dutianze.designpattern.abstractfactory.kingdom.Castle;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class OrcCastle implements Castle {

    @Override
    public String getDescription() {
        return "This is the orc castle!";
    }
}
