package com.dutianze.designpattern.iterator.list;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/8/10
 */
@Data
@AllArgsConstructor
public class Item {

    private ItemType type;
    private final String name;
}
