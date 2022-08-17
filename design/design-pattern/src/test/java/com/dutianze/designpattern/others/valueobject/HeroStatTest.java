package com.dutianze.designpattern.others.valueobject;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/17
 */
class HeroStatTest {

    @Test
    void testToString() {
        HeroStat heroStatA = HeroStat.valueOf(3, 9, 2);
        HeroStat heroStatB = HeroStat.valueOf(3, 9, 2);
        HeroStat heroStatC = HeroStat.valueOf(3, 9, 8);

        assertEquals(heroStatA.toString(), is(heroStatB.toString()));
        assertEquals(heroStatA.toString(), is(not(heroStatC.toString())));
    }

}