package com.dutianze.designpattern.others.tolerantreader.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/21
 */
@Getter
@RequiredArgsConstructor
public class RainbowFish implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private final String name;
  private final int age;
  private final int lengthMeters;
  private final int weightTons;
}
