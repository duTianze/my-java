package com.dutianze.designpattern.behavioral.templatemethod;

import com.dutianze.designpattern.behavioral.templatemethod.stealing.StealingMethod;
import com.dutianze.designpattern.behavioral.templatemethod.stealing.impl.HitAndRunMethod;
import com.dutianze.designpattern.behavioral.templatemethod.stealing.impl.SubtleMethod;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class HalflingThiefTest {

    @Test
    void testThief() {
        HalflingThief thief = new HalflingThief(new HitAndRunMethod());
        thief.steal();
        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }

    @Test
    void testSteal() {
        final StealingMethod method = mock(StealingMethod.class);
        final HalflingThief thief = new HalflingThief(method);

        thief.steal();
        verify(method).steal();

        verifyNoMoreInteractions(method);
    }

    @Test
    void testChangeMethod() {
        final StealingMethod initialMethod = mock(StealingMethod.class);
        final HalflingThief thief = new HalflingThief(initialMethod);

        thief.steal();
        verify(initialMethod).steal();

        final StealingMethod newMethod = mock(StealingMethod.class);
        thief.changeMethod(newMethod);

        thief.steal();
        verify(newMethod).steal();

        verifyNoMoreInteractions(initialMethod, newMethod);
    }
}