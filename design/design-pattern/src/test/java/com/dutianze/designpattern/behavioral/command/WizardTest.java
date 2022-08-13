package com.dutianze.designpattern.behavioral.command;

import com.dutianze.designpattern.behavioral.command.target.Goblin;
import com.dutianze.designpattern.behavioral.command.target.valueobject.Size;
import com.dutianze.designpattern.behavioral.command.target.valueobject.Visibility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class WizardTest {

    private static final String GOBLIN = "Goblin";

    @Test
    void testCommand() {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();

        wizard.castSpell(goblin::changeSize);
        verifyGoblin(goblin, Size.SMALL, Visibility.VISIBLE);

        wizard.castSpell(goblin::changeVisibility);
        verifyGoblin(goblin, Size.SMALL, Visibility.INVISIBLE);

        wizard.undoLastSpell();
        verifyGoblin(goblin, Size.SMALL, Visibility.VISIBLE);

        wizard.undoLastSpell();
        verifyGoblin(goblin, Size.NORMAL, Visibility.VISIBLE);

        wizard.redoLastSpell();
        verifyGoblin(goblin, Size.SMALL, Visibility.VISIBLE);

        wizard.redoLastSpell();
        verifyGoblin(goblin, Size.SMALL, Visibility.INVISIBLE);
    }

    private void verifyGoblin(Goblin goblin, Size expectedSize,
                              Visibility expectedVisibility) {
        assertEquals(WizardTest.GOBLIN, goblin.toString(), "Goblin's name must be same as expectedName");
        assertEquals(expectedSize, goblin.getSize(), "Goblin's size must be same as expectedSize");
        assertEquals(expectedVisibility, goblin.getVisibility(),
                     "Goblin's visibility must be same as expectedVisibility");
    }
}