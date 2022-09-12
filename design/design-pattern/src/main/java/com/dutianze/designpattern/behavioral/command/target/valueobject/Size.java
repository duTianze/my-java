package com.dutianze.designpattern.behavioral.command.target.valueobject;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@RequiredArgsConstructor
public enum Size {

  SMALL("small"),
  NORMAL("normal");

  private final String title;

  @Override
  public String toString() {
    return title;
  }
}