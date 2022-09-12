package com.dutianze.designpattern.creational.prototype.hero;

import com.dutianze.designpattern.creational.prototype.Prototype;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Warlord implements Prototype {

  public Warlord(Warlord source) {
  }

  @Override
  public abstract Warlord copy();

}