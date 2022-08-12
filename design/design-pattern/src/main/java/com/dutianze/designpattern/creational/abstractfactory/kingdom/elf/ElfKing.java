package com.dutianze.designpattern.creational.abstractfactory.kingdom.elf;

import com.dutianze.designpattern.creational.abstractfactory.kingdom.King;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class ElfKing implements King {

    @Override
    public String getDescription() {
        return "This is the elven king!";
    }
}
