package com.dutianze.designpattern.others.transactionscript.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Data
@AllArgsConstructor
public class Room {

    private int id;
    private String roomType;
    private int price;
    private boolean booked;

    public void book() {
        this.booked = true;
    }

    public void cancelBook() {
        this.booked = false;
    }
}