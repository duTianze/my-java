package com.dutianze.designpattern.creational.prototype.factory;

import com.dutianze.designpattern.creational.prototype.hero.Mage;
import com.dutianze.designpattern.creational.prototype.hero.Warlord;
import com.dutianze.designpattern.creational.prototype.hero.Beast;

/**
 * @author dutianze
 * @date 2022/8/9
 */
public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
