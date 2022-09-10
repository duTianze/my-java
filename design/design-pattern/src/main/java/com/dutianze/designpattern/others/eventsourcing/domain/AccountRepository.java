package com.dutianze.designpattern.others.eventsourcing.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/9/11
 */
public class AccountRepository {

    private static Map<Integer, Account> accounts = new HashMap<>();

    public void save(Account account) {
        accounts.put(account.getAccountNo(), account);
    }

    public Account findAccount(int accountNo) {
        return Optional.of(accountNo)
                       .map(accounts::get)
                       .map(Account::copy)
                       .orElse(null);
    }

    public void clear() {
        accounts = new HashMap<>();
    }
}
