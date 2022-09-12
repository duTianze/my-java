package com.dutianze.designpattern.creational.property;

import com.dutianze.designpattern.creational.property.impl.Stats;

/**
 * <h2 id="real-world-examples">Real world examples</h2>
 * <ul>
 * <li><a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain">JavaScript</a> prototype inheritance</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/31
 */
public interface Prototype {

  default Integer get(Stats stat) {
    return null;
  }

  default boolean has(Stats stat) {
    return false;
  }

  default void set(Stats stat, Integer val) {
  }

  default void remove(Stats stat) {
  }
}