package com.dutianze.designpattern.abstractfactory.fatory.impl;

import com.dutianze.designpattern.abstractfactory.fatory.KingdomFactory;
import com.dutianze.designpattern.abstractfactory.kingdom.Army;
import com.dutianze.designpattern.abstractfactory.kingdom.Castle;
import com.dutianze.designpattern.abstractfactory.kingdom.King;
import com.dutianze.designpattern.abstractfactory.kingdom.orc.OrcArmy;
import com.dutianze.designpattern.abstractfactory.kingdom.orc.OrcCastle;
import com.dutianze.designpattern.abstractfactory.kingdom.orc.OrcKing;

/**
 * @author dutianze
 * @date 2022/8/6
 */
public class OrcKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
