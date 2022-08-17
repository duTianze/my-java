package com.dutianze.designpattern.others.valueobject;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author dutianze
 * @date 2022/8/17
 */
class HeroStatTest {

    @Test
    void equalObjectHashCodeIsEqual() {
        HeroStat heroStatA = HeroStat.valueOf(3, 9, 2);
        HeroStat heroStatB = HeroStat.valueOf(3, 9, 2);
        assertThat(heroStatA.hashCode()).isEqualTo(heroStatB.hashCode());
    }

    @Test
    void sampleFieldsIsEqual() {
        HeroStat heroStatA = HeroStat.valueOf(3, 9, 2);
        HeroStat heroStatB = HeroStat.valueOf(3, 9, 2);
        HeroStat heroStatC = HeroStat.valueOf(3, 9, 8);

        assertThat(heroStatA.toString()).isEqualTo(heroStatB.toString());
        assertThat(heroStatA.toString()).isNotEqualTo(heroStatC.toString());
    }
}