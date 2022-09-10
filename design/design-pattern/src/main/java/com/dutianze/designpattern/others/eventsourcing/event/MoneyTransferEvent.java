package com.dutianze.designpattern.others.eventsourcing.event;

import com.dutianze.designpattern.others.eventsourcing.domain.Account;
import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Getter
public class MoneyTransferEvent extends DomainEvent {

    private final BigDecimal money;
    private final int accountNoFrom;
    private final int accountNoTo;

    public MoneyTransferEvent(long sequenceId, long createdTime, BigDecimal money, int accountNoFrom, int accountNoTo) {
        super(sequenceId, createdTime, "MoneyTransferEvent");
        this.money = money;
        this.accountNoFrom = accountNoFrom;
        this.accountNoTo = accountNoTo;
    }

    @Override
    public void process(AccountRepository accountRepository) {
        Account accountFrom = Optional.ofNullable(accountRepository.findAccount(accountNoFrom))
                                      .orElseThrow(() -> new RuntimeException("Account not found " + accountNoFrom));
        Account accountTo = Optional.ofNullable(accountRepository.findAccount(accountNoTo))
                                    .orElseThrow(() -> new RuntimeException("Account not found " + accountNoTo));

        accountFrom.withdraw(money);
        accountTo.deposit(money);

        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
    }
}
