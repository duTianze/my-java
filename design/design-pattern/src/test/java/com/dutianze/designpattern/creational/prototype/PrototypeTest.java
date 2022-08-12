package com.dutianze.designpattern.creational.prototype;

import com.dutianze.designpattern.creational.prototype.Prototype;
import com.dutianze.designpattern.creational.prototype.hero.impl.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/9
 */
public class PrototypeTest<P extends Prototype> {

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
