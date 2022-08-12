package com.dutianze.designpattern.creational.prototype.hero.impl;

import com.dutianze.designpattern.creational.prototype.hero.Beast;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrcBeast extends Beast {

    private final String weapon;

    public OrcBeast(OrcBeast orcBeast) {
        super(orcBeast);
        this.weapon = orcBeast.weapon;
    }

    @Override
    public OrcBeast copy() {
        return new OrcBeast(this);
    }

    @Override
    public String toString() {
        return "Orcish wolf attacks with " + weapon;
    }

}
