package com.dutianze.designpattern.others.servicelocator.service.impl;

import com.dutianze.designpattern.others.servicelocator.service.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Slf4j
public class ServiceImpl implements Service {

  private final String serviceName;
  private final int id;

  public ServiceImpl(String serviceName) {
    this.serviceName = serviceName;
    this.id = (int) Math.floor(Math.random() * 1000) + 1;
  }

  @Override
  public String getName() {
    return serviceName;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void execute() {
    log.info("Service {} is now executing with id {}", getName(), getId());
  }
}

