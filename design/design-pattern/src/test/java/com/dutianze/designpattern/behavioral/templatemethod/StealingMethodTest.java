package com.dutianze.designpattern.behavioral.templatemethod;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.dutianze.designpattern.behavioral.templatemethod.impl.HitAndRunMethod;
import com.dutianze.designpattern.behavioral.templatemethod.impl.SubtleMethod;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class StealingMethodTest {

  @Test
  void useCase() {
    assertDoesNotThrow(() -> {
      StealingMethod stealingMethod = new HitAndRunMethod();
      stealingMethod.steal();

      stealingMethod = new SubtleMethod();
      stealingMethod.steal();
    });
  }

  @Test
  void verifySteal() {
    final StealingMethod method = mock(StealingMethod.class);

    method.steal();
    verify(method).steal();

    verifyNoMoreInteractions(method);
  }
}