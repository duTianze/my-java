package com.dutianze.designpattern.behavioral.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dutianze.designpattern.behavioral.memento.star.Star;
import com.dutianze.designpattern.behavioral.memento.star.StarType;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class StarTest {

  @Test
  void testTimePasses() {
    final Star star = new Star(StarType.SUN, 1, 2);
    assertEquals("sun age: 1 years mass: 2 tons", star.toString());

    star.timePasses();
    assertEquals("red giant age: 2 years mass: 16 tons", star.toString());

    star.timePasses();
    assertEquals("white dwarf age: 4 years mass: 128 tons", star.toString());

    star.timePasses();
    assertEquals("supernova age: 8 years mass: 1024 tons", star.toString());

    star.timePasses();
    assertEquals("dead star age: 16 years mass: 8192 tons", star.toString());

    star.timePasses();
    assertEquals("dead star age: 64 years mass: 0 tons", star.toString());

    star.timePasses();
    assertEquals("dead star age: 256 years mass: 0 tons", star.toString());
  }

  @Test
  void testSetMemento() {
    final Star star = new Star(StarType.SUN, 1, 2);
    final StarMemento firstMemento = star.getMemento();
    assertEquals("sun age: 1 years mass: 2 tons", star.toString());

    star.timePasses();
    final StarMemento secondMemento = star.getMemento();
    assertEquals("red giant age: 2 years mass: 16 tons", star.toString());

    star.timePasses();
    final StarMemento thirdMemento = star.getMemento();
    assertEquals("white dwarf age: 4 years mass: 128 tons", star.toString());

    star.timePasses();
    assertEquals("supernova age: 8 years mass: 1024 tons", star.toString());

    star.setMemento(thirdMemento);
    assertEquals("white dwarf age: 4 years mass: 128 tons", star.toString());

    star.timePasses();
    assertEquals("supernova age: 8 years mass: 1024 tons", star.toString());

    star.setMemento(secondMemento);
    assertEquals("red giant age: 2 years mass: 16 tons", star.toString());

    star.setMemento(firstMemento);
    assertEquals("sun age: 1 years mass: 2 tons", star.toString());
  }
}