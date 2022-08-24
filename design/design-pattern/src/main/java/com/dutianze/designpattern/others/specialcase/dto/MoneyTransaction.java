package com.dutianze.designpattern.others.specialcase.dto;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class MoneyTransaction {

    private final Double amount;
    private final Double price;

    public MoneyTransaction(Double amount, Double price) {
        this.amount = amount;
        this.price = price;
    }
}
