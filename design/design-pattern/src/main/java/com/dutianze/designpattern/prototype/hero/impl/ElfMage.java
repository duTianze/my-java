package com.dutianze.designpattern.prototype.hero.impl;

import com.dutianze.designpattern.prototype.hero.Mage;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ElfMage extends Mage {

    private final String helpType;

    public ElfMage(ElfMage elfMage) {
        super(elfMage);
        this.helpType = elfMage.helpType;
    }

    @Override
    public ElfMage copy() {
        return new ElfMage(this);
    }

    @Override
    public String toString() {
        return "Elven mage helps in " + helpType;
    }

}
