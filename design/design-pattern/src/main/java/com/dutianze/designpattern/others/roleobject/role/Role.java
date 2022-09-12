package com.dutianze.designpattern.others.roleobject.role;

import com.dutianze.designpattern.others.roleobject.core.CustomerRole;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public enum Role {

  Borrower(BorrowerRole.class), Investor(InvestorRole.class);

  private final Class<? extends CustomerRole> typeCst;

  Role(Class<? extends CustomerRole> typeCst) {
    this.typeCst = typeCst;
  }

  @SuppressWarnings("unchecked")
  public <T extends CustomerRole> Optional<T> instance() {
    Class<? extends CustomerRole> typeCst = this.typeCst;
    try {
      return (Optional<T>) Optional.of(typeCst.getDeclaredConstructor().newInstance());
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
             InvocationTargetException e) {
      log.error("error creating an object", e);
    }
    return Optional.empty();
  }
}
