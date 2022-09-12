package com.dutianze.designpattern.others.specialcase.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class MaintenanceLock {

  private static MaintenanceLock instance;
  private boolean lock = true;

  public static synchronized MaintenanceLock getInstance() {
    if (instance == null) {
      instance = new MaintenanceLock();
    }
    return instance;
  }

  public boolean isLock() {
    return lock;
  }

  public void setLock(boolean lock) {
    this.lock = lock;
    log.info("Maintenance lock is set to:{}", lock);
  }
}
