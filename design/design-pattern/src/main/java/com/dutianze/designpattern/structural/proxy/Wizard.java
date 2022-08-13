package com.dutianze.designpattern.structural.proxy;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@RequiredArgsConstructor
public class Wizard {

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}