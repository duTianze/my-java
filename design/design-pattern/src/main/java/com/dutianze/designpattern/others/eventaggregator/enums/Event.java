package com.dutianze.designpattern.others.eventaggregator.enums;

import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@RequiredArgsConstructor
public enum Event {

  WHITE_WALKERS_SIGHTED("White walkers sighted"),
  STARK_SIGHTED("Stark sighted"),
  WARSHIPS_APPROACHING("Warships approaching"),
  TRAITOR_DETECTED("Traitor detected");

  private final String description;

  @Override
  public String toString() {
    return description;
  }
}
