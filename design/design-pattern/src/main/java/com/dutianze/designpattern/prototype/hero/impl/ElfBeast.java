package com.dutianze.designpattern.prototype.hero.impl;

import com.dutianze.designpattern.prototype.hero.Beast;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class ElfBeast extends Beast {

    private final String helpType;

    public ElfBeast(ElfBeast elfBeast) {
        super(elfBeast);
        this.helpType = elfBeast.helpType;
    }

    @Override
    public ElfBeast copy() {
        return new ElfBeast(this);
    }

    @Override
    public String toString() {
        return "Elven eagle helps in " + helpType;
    }

}