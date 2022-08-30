package com.dutianze.designpattern.creational.prototype;

import com.dutianze.designpattern.creational.prototype.factory.HeroFactoryImpl;
import com.dutianze.designpattern.creational.prototype.hero.Beast;
import com.dutianze.designpattern.creational.prototype.hero.Mage;
import com.dutianze.designpattern.creational.prototype.hero.Warlord;
import com.dutianze.designpattern.creational.prototype.hero.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@Slf4j
public class PrototypeTest<P extends Prototype> {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            HeroFactoryImpl factory = new HeroFactoryImpl(
                    new ElfMage("cooking"),
                    new ElfWarlord("cleaning"),
                    new ElfBeast("protecting")
            );
            Mage mage = factory.createMage();
            Warlord warlord = factory.createWarlord();
            Beast beast = factory.createBeast();
            log.info(mage.toString());
            log.info(warlord.toString());
            log.info(beast.toString());

            factory = new HeroFactoryImpl(
                    new OrcMage("axe"),
                    new OrcWarlord("sword"),
                    new OrcBeast("laser")
            );
            mage = factory.createMage();
            warlord = factory.createWarlord();
            beast = factory.createBeast();
            log.info(mage.toString());
            log.info(warlord.toString());
            log.info(beast.toString());
        });
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testPrototype(P testedPrototype, String expectedToString) {
        assertEquals(expectedToString, testedPrototype.toString());

        final Object clone = testedPrototype.copy();
        assertNotNull(clone);
        assertNotSame(clone, testedPrototype);
        assertSame(testedPrototype.getClass(), clone.getClass());
        assertEquals(clone, testedPrototype);
    }

    static Collection<Object[]> dataProvider() {
        return List.of(
                new Object[]{new OrcBeast("axe"), "Orcish wolf attacks with axe"},
                new Object[]{new OrcMage("sword"), "Orcish mage attacks with sword"},
                new Object[]{new OrcWarlord("laser"), "Orcish warlord attacks with laser"},
                new Object[]{new ElfBeast("cooking"), "Elven eagle helps in cooking"},
                new Object[]{new ElfMage("cleaning"), "Elven mage helps in cleaning"},
                new Object[]{new ElfWarlord("protecting"), "Elven warlord helps in protecting"}
        );
    }

}
