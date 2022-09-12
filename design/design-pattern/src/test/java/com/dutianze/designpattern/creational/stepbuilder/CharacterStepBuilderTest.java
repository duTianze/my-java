package com.dutianze.designpattern.creational.stepbuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

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