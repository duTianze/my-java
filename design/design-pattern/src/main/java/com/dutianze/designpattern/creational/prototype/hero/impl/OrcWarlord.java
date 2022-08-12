package com.dutianze.designpattern.creational.prototype.hero.impl;

import com.dutianze.designpattern.creational.prototype.hero.Warlord;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcWarlord extends Warlord {

    private final String weapon;

    public OrcWarlord(OrcWarlord orcWarlord) {
        super(orcWarlord);
        this.weapon = orcWarlord.weapon;
    }

    @Override
    public OrcWarlord copy() {
        return new OrcWarlord(this);
    }

    @Override
    public String toString() {
        return "Orcish warlord attacks with " + weapon;
    }

}
