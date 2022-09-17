package com.dutianze.designpattern.behavioral.command.types;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@RequiredArgsConstructor
public enum Visibility {

  VISIBLE("visible"),
  INVISIBLE("invisible");

  private final String title;

  @Override
  public String toString() {
    return title;
  }
}