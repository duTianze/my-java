package com.dutianze.designpattern.others.specification;

import com.dutianze.designpattern.others.specification.creature.Creature;
import com.dutianze.designpattern.others.specification.creature.impl.*;
import com.dutianze.designpattern.others.specification.property.Color;
import com.dutianze.designpattern.others.specification.property.Mass;
import com.dutianze.designpattern.others.specification.property.Movement;
import com.dutianze.designpattern.others.specification.selector.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
class AbstractSelectorTest {

    @Test
    void usage() {
        assertDoesNotThrow((() -> {

            List<AbstractCreature> creatures = List.of(
                    new Goblin(),
                    new Octopus(),
                    new Dragon(),
                    new Shark(),
                    new Troll(),
                    new KillerBee()
            );
            log.info("Demonstrating hard-coded specification :");
            log.info("Find all walking creatures");
            print(creatures, new MovementSelector(Movement.WALKING));

            log.info("Find all dark creatures");
            print(creatures, new ColorSelector(Color.DARK));

            log.info("\n");
            log.info("Demonstrating parameterized specification :");
            log.info("Find all creatures heavier than 600kg");
            print(creatures, new MassGreaterThanSelector(600.0));

            log.info("Find all creatures lighter than or weighing exactly 500kg");
            print(creatures, new MassSmallerThanOrEqSelector(500.0));

            log.info("\n");
            log.info("Demonstrating composite specification :");
            log.info("Find all red and flying creatures");
            AbstractSelector<Creature> redAndFlying =
                    new ColorSelector(Color.RED).and(new MovementSelector(Movement.FLYING));
            print(creatures, redAndFlying);

            log.info("Find all scary creatures");
            AbstractSelector<Creature> scaryCreaturesSelector = new ColorSelector(Color.DARK)
                    .or(new ColorSelector(Color.RED)).and(new MovementSelector(Movement.SWIMMING).not())
                    .and(new MassGreaterThanSelector(400.0).or(new MassEqualSelector(400.0)));
            print(creatures, scaryCreaturesSelector);
        }));
    }

    @Test
    void testMovement() {
        final Creature swimmingCreature = mock(Creature.class);
        when(swimmingCreature.getMovement()).thenReturn(Movement.SWIMMING);

        final Creature flyingCreature = mock(Creature.class);
        when(flyingCreature.getMovement()).thenReturn(Movement.FLYING);

        final MovementSelector swimmingSelector = new MovementSelector(Movement.SWIMMING);
        assertTrue(swimmingSelector.test(swimmingCreature));
        assertFalse(swimmingSelector.test(flyingCreature));
    }

    @Test
    void testAndComposition() {
        final Creature swimmingHeavyCreature = mock(Creature.class);
        when(swimmingHeavyCreature.getMovement()).thenReturn(Movement.SWIMMING);
        when(swimmingHeavyCreature.getMass()).thenReturn(new Mass(100.0));

        final Creature swimmingLightCreature = mock(Creature.class);
        when(swimmingLightCreature.getMovement()).thenReturn(Movement.SWIMMING);
        when(swimmingLightCreature.getMass()).thenReturn(new Mass(25.0));

        final AbstractSelector<Creature> lightAndSwimmingSelector = new MassSmallerThanOrEqSelector(50.0)
                .and(new MovementSelector(Movement.SWIMMING));
        assertFalse(lightAndSwimmingSelector.test(swimmingHeavyCreature));
        assertTrue(lightAndSwimmingSelector.test(swimmingLightCreature));
    }

    @Test
    void testOrComposition() {
        final Creature swimmingHeavyCreature = mock(Creature.class);
        when(swimmingHeavyCreature.getMovement()).thenReturn(Movement.SWIMMING);
        when(swimmingHeavyCreature.getMass()).thenReturn(new Mass(100.0));

        final Creature swimmingLightCreature = mock(Creature.class);
        when(swimmingLightCreature.getMovement()).thenReturn(Movement.SWIMMING);
        when(swimmingLightCreature.getMass()).thenReturn(new Mass(25.0));

        final AbstractSelector<Creature> lightOrSwimmingSelector = new MassSmallerThanOrEqSelector(50.0)
                .or(new MovementSelector(Movement.SWIMMING));
        assertTrue(lightOrSwimmingSelector.test(swimmingHeavyCreature));
        assertTrue(lightOrSwimmingSelector.test(swimmingLightCreature));
    }

    @Test
    void testMass() {
        final Creature lightCreature = mock(Creature.class);
        when(lightCreature.getMass()).thenReturn(new Mass(50.0));

        final Creature heavyCreature = mock(Creature.class);
        when(heavyCreature.getMass()).thenReturn(new Mass(2500.0));

        final MassSmallerThanOrEqSelector lightSelector = new MassSmallerThanOrEqSelector(500.0);
        assertTrue(lightSelector.test(lightCreature));
        assertFalse(lightSelector.test(heavyCreature));
    }

    @Test
    void testColor() {
        final Creature greenCreature = mock(Creature.class);
        when(greenCreature.getColor()).thenReturn(Color.GREEN);

        final Creature redCreature = mock(Creature.class);
        when(redCreature.getColor()).thenReturn(Color.RED);

        final ColorSelector greenSelector = new ColorSelector(Color.GREEN);
        assertTrue(greenSelector.test(greenCreature));
        assertFalse(greenSelector.test(redCreature));
    }

    private void print(List<? extends Creature> creatures, Predicate<Creature> selector) {
        creatures.stream().filter(selector).map(Objects::toString).forEach(log::info);
    }
}