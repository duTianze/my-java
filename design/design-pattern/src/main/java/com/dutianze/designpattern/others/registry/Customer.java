package com.dutianze.designpattern.others.registry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Getter
@ToString
@RequiredArgsConstructor
public class Customer {

    private final String id;
    private final String name;
}
