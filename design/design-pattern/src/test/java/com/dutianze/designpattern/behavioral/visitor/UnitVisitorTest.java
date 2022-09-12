package com.dutianze.designpattern.behavioral.visitor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.behavioral.visitor.impl.CommanderVisitor;
import com.dutianze.designpattern.behavioral.visitor.impl.SergeantVisitor;
import com.dutianze.designpattern.behavioral.visitor.impl.SoldierVisitor;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Commander;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Sergeant;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Soldier;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class UnitVisitorTest {

  @Test
  void shouldExecuteWithoutException() {
    assertDoesNotThrow(() -> {
      Commander commander = new Commander(
          new Sergeant(new Soldier(), new Soldier(), new Soldier()),
          new Sergeant(new Soldier(), new Soldier(), new Soldier())
      );
      commander.accept(new SoldierVisitor());
      commander.accept(new SergeantVisitor());
      commander.accept(new CommanderVisitor());
    });
  }
}