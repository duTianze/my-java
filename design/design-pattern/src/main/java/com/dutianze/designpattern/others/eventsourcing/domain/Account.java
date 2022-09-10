package com.dutianze.designpattern.others.eventsourcing.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Slf4j
@Data
@RequiredArgsConstructor
public class Account {

    private final int accountNo;
    private final String owner;
    private BigDecimal available = BigDecimal.ZERO;

    public Account copy() {
        Account account = new Account(accountNo, owner);
        account.setAvailable(available);
        return account;
    }

    public void deposit(BigDecimal money) {
        this.available = this.available.add(money);
    }

    public void withdraw(BigDecimal money) {
        if (this.available.compareTo(money) < 0) {
            throw new RuntimeException("InsufficientFundsException");
        }
        this.available = this.available.subtract(money);
    }
}
