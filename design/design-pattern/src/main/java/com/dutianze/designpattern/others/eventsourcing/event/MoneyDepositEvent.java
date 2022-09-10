package com.dutianze.designpattern.others.eventsourcing.event;

import com.dutianze.designpattern.others.eventsourcing.domain.Account;
import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Slf4j
@Getter
public class MoneyDepositEvent extends DomainEvent {

    private final BigDecimal money;
    private final int accountNo;

    public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
        super(sequenceId, createdTime, "MoneyDepositEvent");
        this.money = money;
        this.accountNo = accountNo;
    }

    @Override
    public void process(AccountRepository accountRepository) {
        Account account = Optional.ofNullable(accountRepository.findAccount(accountNo))
                                  .orElseThrow(() -> new RuntimeException("Account not found"));

        account.deposit(money);
        accountRepository.save(account);
        if (this.isRealTime()) {
            log.info(MSG);
        }
    }
}
