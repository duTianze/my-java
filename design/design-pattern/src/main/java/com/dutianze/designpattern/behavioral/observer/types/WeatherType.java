package com.dutianze.designpattern.behavioral.observer.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Getter
@RequiredArgsConstructor
public enum WeatherType {

  SUNNY("Sunny"),

  RAINY("Rainy"),

  WINDY("Windy"),

  COLD("Cold");

  private final String description;

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}