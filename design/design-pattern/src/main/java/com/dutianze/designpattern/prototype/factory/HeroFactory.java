package com.dutianze.designpattern.prototype.factory;

import com.dutianze.designpattern.prototype.hero.Beast;
import com.dutianze.designpattern.prototype.hero.Mage;
import com.dutianze.designpattern.prototype.hero.Warlord;

/**
 * @author dutianze
 * @date 2022/8/9
 */
public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
