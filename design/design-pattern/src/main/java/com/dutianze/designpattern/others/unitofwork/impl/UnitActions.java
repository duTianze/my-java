package com.dutianze.designpattern.others.unitofwork.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/19
 */
@Getter
@RequiredArgsConstructor
public enum UnitActions {

  INSERT("INSERT"),
  DELETE("DELETE"),
  MODIFY("MODIFY");

  private final String actionValue;
}