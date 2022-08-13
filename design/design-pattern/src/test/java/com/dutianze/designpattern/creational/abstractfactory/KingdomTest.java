package com.dutianze.designpattern.creational.abstractfactory;

import com.dutianze.designpattern.creational.abstractfactory.fatory.KingdomFactory;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.King;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.Kingdom;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.elf.ElfKing;
import com.dutianze.designpattern.creational.abstractfactory.kingdom.orc.OrcKing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/8/6
 */
class KingdomTest {

    @Test
    void verifyKingCreation() {
        KingdomFactory elfKingdomFactory = KingdomFactory.makeFactory(KingdomFactory.KingdomType.ELF);
        Kingdom elfKingdom = elfKingdomFactory.createKingdom();

        King elfKing = elfKingdom.getKing();
        assertTrue(elfKing instanceof ElfKing);

        KingdomFactory rocKingdomFactory = KingdomFactory.makeFactory(KingdomFactory.KingdomType.ORC);
        Kingdom orcKingdom = rocKingdomFactory.createKingdom();
        final King orcKing = orcKingdom.getKing();
        assertTrue(orcKing instanceof OrcKing);
    }
}