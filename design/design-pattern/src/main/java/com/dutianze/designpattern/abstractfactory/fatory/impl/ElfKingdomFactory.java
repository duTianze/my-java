package com.dutianze.designpattern.abstractfactory.fatory.impl;

import com.dutianze.designpattern.abstractfactory.fatory.KingdomFactory;
import com.dutianze.designpattern.abstractfactory.kingdom.Army;
import com.dutianze.designpattern.abstractfactory.kingdom.Castle;
import com.dutianze.designpattern.abstractfactory.kingdom.King;
import com.dutianze.designpattern.abstractfactory.kingdom.elf.ElfArmy;
import com.dutianze.designpattern.abstractfactory.kingdom.elf.ElfCastle;
import com.dutianze.designpattern.abstractfactory.kingdom.elf.ElfKing;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class ElfKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
