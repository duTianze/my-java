package com.dutianze.designpattern.others.specification.selector;

import com.dutianze.designpattern.others.specification.creature.Creature;
import com.dutianze.designpattern.others.specification.creature.impl.*;
import com.dutianze.designpattern.others.specification.property.Color;
import com.dutianze.designpattern.others.specification.property.Movement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    private void print(List<? extends Creature> creatures, Predicate<Creature> selector) {
        creatures.stream().filter(selector).map(Objects::toString).forEach(log::info);
    }
}