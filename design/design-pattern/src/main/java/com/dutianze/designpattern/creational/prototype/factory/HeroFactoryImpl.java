package com.dutianze.designpattern.creational.prototype.factory;

import com.dutianze.designpattern.creational.prototype.hero.Mage;
import com.dutianze.designpattern.creational.prototype.hero.Warlord;
import com.dutianze.designpattern.creational.prototype.hero.Beast;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@RequiredArgsConstructor
public class HeroFactoryImpl implements HeroFactory {

    private final Mage mage;
    private final Warlord warlord;
    private final Beast beast;

    public Mage createMage() {
        return mage.copy();
    }

    public Warlord createWarlord() {
        return warlord.copy();
    }

    public Beast createBeast() {
        return beast.copy();
    }

}
