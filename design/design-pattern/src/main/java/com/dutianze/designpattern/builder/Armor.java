package com.dutianze.designpattern.builder;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/7
 */
@RequiredArgsConstructor
public enum Armor {

    CLOTHES("clothes"),
    LEATHER("leather"),
    CHAIN_MAIL("chain mail"),
    PLATE_MAIL("plate mail");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
