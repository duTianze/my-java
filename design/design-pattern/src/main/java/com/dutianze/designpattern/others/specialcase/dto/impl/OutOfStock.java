package com.dutianze.designpattern.others.specialcase.dto.impl;

import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class OutOfStock implements ReceiptViewModel {

    private final String userName;
    private final String itemName;

    public OutOfStock(String userName, String itemName) {
        this.userName = userName;
        this.itemName = itemName;
    }

    @Override
    public void show() {
        log.warn("Out of stock: {} for user = {} to buy", itemName, userName);
    }
}
