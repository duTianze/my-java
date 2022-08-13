package com.dutianze.designpattern.structural.flyweight;

import com.dutianze.designpattern.structural.flyweight.potion.Potion;
import com.dutianze.designpattern.structural.flyweight.potion.PotionType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#valueOf%28int%29">java.lang.Integer#valueOf(int)</a> and similarly for Byte, Character and other wrapped types.</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/13
 * @see Integer#valueOf(int)
 */
@Slf4j
public class AlchemistShop {

    private final List<Potion> shelf;

    public AlchemistShop() {
        PotionFactory factory = new PotionFactory();
        shelf = List.of(
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.INVISIBILITY),
                factory.createPotion(PotionType.STRENGTH),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.HEALING),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.POISON),
                factory.createPotion(PotionType.HOLY_WATER),
                factory.createPotion(PotionType.HOLY_WATER)
        );
    }

    public final List<Potion> getShelf() {
        return List.copyOf(this.shelf);
    }

    public void drinkPotions() {
        log.info("Drinking top shelf potions");
        shelf.forEach(Potion::drink);
    }
}