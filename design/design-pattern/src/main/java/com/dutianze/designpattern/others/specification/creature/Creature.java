package com.dutianze.designpattern.others.specification.creature;

import com.dutianze.designpattern.others.specification.property.Color;
import com.dutianze.designpattern.others.specification.property.Mass;
import com.dutianze.designpattern.others.specification.property.Movement;
import com.dutianze.designpattern.others.specification.property.Size;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public interface Creature {

  String getName();

  Size getSize();

  Movement getMovement();

  Color getColor();

  Mass getMass();
}
