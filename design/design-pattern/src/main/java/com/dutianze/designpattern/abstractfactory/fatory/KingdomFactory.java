package com.dutianze.designpattern.abstractfactory.fatory;

import com.dutianze.designpattern.abstractfactory.fatory.impl.ElfKingdomFactory;
import com.dutianze.designpattern.abstractfactory.fatory.impl.OrcKingdomFactory;
import com.dutianze.designpattern.abstractfactory.kingdom.Army;
import com.dutianze.designpattern.abstractfactory.kingdom.Castle;
import com.dutianze.designpattern.abstractfactory.kingdom.King;
import com.dutianze.designpattern.abstractfactory.kingdom.Kingdom;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();

    default Kingdom createKingdom() {
        return new Kingdom(this);
    }

    enum KingdomType {
        ELF, ORC
    }

    static KingdomFactory makeFactory(KingdomType type) {
        return switch (type) {
            case ELF -> new ElfKingdomFactory();
            case ORC -> new OrcKingdomFactory();
        };
    }
}
