package com.dutianze.designpattern.others.eventsourcing.event;

import com.dutianze.designpattern.others.eventsourcing.domain.AccountRepository;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Setter
@Getter
@RequiredArgsConstructor
public abstract class DomainEvent implements Serializable {

  protected static final String MSG = "Some external api for only realtime execution could be called here.";

  private final long sequenceId;
  private final long createdTime;
  private final String eventClassName;
  private boolean realTime = true;

  public abstract void process(AccountRepository accountRepository);
}
