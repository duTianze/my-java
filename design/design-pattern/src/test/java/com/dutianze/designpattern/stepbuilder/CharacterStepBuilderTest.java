package com.dutianze.designpattern.stepbuilder;

import com.dutianze.designpattern.creational.stepbuilder.Character;
import com.dutianze.designpattern.creational.stepbuilder.CharacterStepBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/9
 */
class CharacterStepBuilderTest {

    @Test
    void testBuildWizard() {
        final Character character = CharacterStepBuilder.newBuilder()
                                                        .name("Merlin")
                                                        .wizardClass("alchemist")
                                                        .withSpell("poison")
                                                        .withAbility("invisibility")
                                                        .withAbility("wisdom")
                                                        .noMoreAbilities()
                                                        .build();

        assertEquals("Merlin", character.getName());
        assertEquals("alchemist", character.getWizardClass());
        assertEquals("poison", character.getSpell());
        assertNotNull(character.toString());

        final List<String> abilities = character.getAbilities();
        assertNotNull(abilities);
        assertEquals(2, abilities.size());
        assertTrue(abilities.contains("invisibility"));
        assertTrue(abilities.contains("wisdom"));

    }

}