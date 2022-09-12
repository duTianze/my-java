package com.dutianze.designpattern.others.unitofwork.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/19
 */
@Getter
@RequiredArgsConstructor
public class Weapon {

  private final Integer id;
  private final String name;
}