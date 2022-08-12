package com.dutianze.designpattern.builder;

import com.dutianze.designpattern.creational.builder.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/8
 */
class HeroTest {

    @Test
    void throwExceptionWhenMissingName() {
        assertThrows(IllegalArgumentException.class, () -> new Hero.Builder(Profession.THIEF, null));
    }

    @Test
    void buildHero() {
        final String heroName = "Sir Lancelot";

        final Hero hero = new Hero.Builder(Profession.WARRIOR, heroName)
                .withArmor(Armor.CHAIN_MAIL)
                .withWeapon(Weapon.SWORD)
                .withHairType(HairType.LONG_CURLY)
                .withHairColor(HairColor.BLOND)
                .build();

        assertNotNull(hero);
        assertNotNull(hero.toString());
        assertEquals(Profession.WARRIOR, hero.getProfession());
        assertEquals(heroName, hero.getName());
        assertEquals(Armor.CHAIN_MAIL, hero.getArmor());
        assertEquals(Weapon.SWORD, hero.getWeapon());
        assertEquals(HairType.LONG_CURLY, hero.getHairType());
        assertEquals(HairColor.BLOND, hero.getHairColor());
    }

}