package com.dutianze.designpattern.abstractfactory.kingdom.elf;

import com.dutianze.designpattern.abstractfactory.kingdom.Army;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class ElfArmy implements Army {

    @Override
    public String getDescription() {
        return "This is the elven army!";
    }
}
