package com.dutianze.designpattern.prototype.hero.impl;

import com.dutianze.designpattern.prototype.hero.Warlord;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class ElfWarlord extends Warlord {

    private final String helpType;

    public ElfWarlord(ElfWarlord elfWarlord) {
        super(elfWarlord);
        this.helpType = elfWarlord.helpType;
    }

    @Override
    public ElfWarlord copy() {
        return new ElfWarlord(this);
    }

    @Override
    public String toString() {
        return "Elven warlord helps in " + helpType;
    }
}
