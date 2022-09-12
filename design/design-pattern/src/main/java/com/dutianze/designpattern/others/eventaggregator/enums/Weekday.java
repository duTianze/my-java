package com.dutianze.designpattern.others.eventaggregator.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@RequiredArgsConstructor
public enum Weekday {

  MONDAY("Monday"),
  TUESDAY("Tuesday"),
  WEDNESDAY("Wednesday"),
  THURSDAY("Thursday"),
  FRIDAY("Friday"),
  SATURDAY("Saturday"),
  SUNDAY("Sunday");

  private final String description;

  @Override
  public String toString() {
    return description;
  }
}
