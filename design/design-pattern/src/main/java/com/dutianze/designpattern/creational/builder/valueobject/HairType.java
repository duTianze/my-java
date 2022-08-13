package com.dutianze.designpattern.creational.builder.valueobject;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/7
 */
@RequiredArgsConstructor
public enum HairType {

    BALD("bald"),
    SHORT("short"),
    CURLY("curly"),
    LONG_STRAIGHT("long straight"),
    LONG_CURLY("long curly");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
