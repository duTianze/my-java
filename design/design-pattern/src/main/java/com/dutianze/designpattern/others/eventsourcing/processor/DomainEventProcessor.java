package com.dutianze.designpattern.others.eventsourcing.processor;

import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import com.dutianze.designpattern.others.eventsourcing.event.DomainEvent;

/**
 * @author dutianze
 * @date 2022/9/11
 */
public class DomainEventProcessor {

  private final JsonFileJournal processorJournal = new JsonFileJournal();
  private final AccountRepository accountRepository = new AccountRepository();

  public void process(DomainEvent domainEvent) {
    domainEvent.process(accountRepository);
    processorJournal.write(domainEvent);
  }

  public void reset() {
    processorJournal.reset();
  }

  public void recover() {
    DomainEvent domainEvent;
    while ((domainEvent = processorJournal.readNext()) != null) {
      domainEvent.process(accountRepository);
    }
  }
}
