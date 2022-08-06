package com.dutianze.designpattern.abstractfactory.kingdom.elf;

import com.dutianze.designpattern.abstractfactory.kingdom.Castle;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class ElfCastle implements Castle {

    @Override
    public String getDescription() {
        return "This is the elven castle!";
    }
}
