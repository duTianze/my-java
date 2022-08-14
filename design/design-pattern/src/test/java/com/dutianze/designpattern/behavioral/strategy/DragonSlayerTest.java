package com.dutianze.designpattern.behavioral.strategy;

import com.dutianze.designpattern.behavioral.strategy.strategy.DragonSlayingStrategy;
import com.dutianze.designpattern.behavioral.strategy.strategy.impl.MeleeStrategy;
import com.dutianze.designpattern.behavioral.strategy.strategy.impl.ProjectileStrategy;
import com.dutianze.designpattern.behavioral.strategy.strategy.impl.SpellStrategy;
import com.dutianze.designpattern.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class DragonSlayerTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    void testGoToBattle() {
        final DragonSlayingStrategy strategy = mock(DragonSlayingStrategy.class);
        final DragonSlayer dragonSlayer = new DragonSlayer(strategy);

        dragonSlayer.goToBattle();
        verify(strategy).execute();
        verifyNoMoreInteractions(strategy);
    }

    @Test
    void testChangeStrategy() {
        final DragonSlayingStrategy initialStrategy = mock(DragonSlayingStrategy.class);
        final DragonSlayer dragonSlayer = new DragonSlayer(initialStrategy);

        dragonSlayer.goToBattle();
        verify(initialStrategy).execute();

        final DragonSlayingStrategy newStrategy = mock(DragonSlayingStrategy.class);
        dragonSlayer.changeStrategy(newStrategy);

        dragonSlayer.goToBattle();
        verify(newStrategy).execute();

        verifyNoMoreInteractions(initialStrategy, newStrategy);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testExecute(DragonSlayingStrategy strategy, String expectedResult) {
        strategy.execute();
        assertEquals(expectedResult, appender.getLastMessage());
        assertEquals(1, appender.getLogSize());
    }

    static Collection<Object[]> dataProvider() {
        return List.of(
                new Object[]{
                        new MeleeStrategy(),
                        "With your Excalibur you sever the dragon's head!"
                },
                new Object[]{
                        new ProjectileStrategy(),
                        "You shoot the dragon with the magical crossbow and it falls dead on the ground!"
                },
                new Object[]{
                        new SpellStrategy(),
                        "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"
                }
        );
    }
}