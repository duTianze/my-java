package com.dutianze.designpattern.creational.prototype.hero.impl;

import com.dutianze.designpattern.creational.prototype.hero.Mage;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcMage extends Mage {

    private final String weapon;

    public OrcMage(OrcMage orcMage) {
        super(orcMage);
        this.weapon = orcMage.weapon;
    }

    @Override
    public OrcMage copy() {
        return new OrcMage(this);
    }

    @Override
    public String toString() {
        return "Orcish mage attacks with " + weapon;
    }

}