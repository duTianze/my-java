package com.dutianze.designpattern.others.eventsourcing.event;

import com.dutianze.designpattern.others.eventsourcing.domain.Account;
import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Slf4j
@Getter
public class AccountCreateEvent extends DomainEvent {

  private final int accountNo;
  private final String owner;

  public AccountCreateEvent(long sequenceId, long createdTime, int accountNo, String owner) {
    super(sequenceId, createdTime, "AccountCreateEvent");
    this.accountNo = accountNo;
    this.owner = owner;
  }

  @Override
  public void process(AccountRepository accountRepository) {
    Account account = accountRepository.findAccount(accountNo);
    if (account != null) {
      throw new RuntimeException("Account already exists");
    }
    account = new Account(accountNo, owner);
    accountRepository.save(account);
    if (this.isRealTime()) {
      log.info(MSG);
    }
  }
}
