package com.dutianze.designpattern.game.typeobject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dutianze.designpattern.game.typeobject.resource.JsonParser;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/20
 */
class MonsterTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      JsonParser jsonParser = new JsonParser();
      Collection<Breed> breeds = jsonParser.loadBreed();

      assertEquals(3, breeds.size());

      List<Monster> monsters = breeds.stream().map(Breed::newMonster).toList();

      assertEquals(3, monsters.stream().map(Monster::getAttack).distinct().count());
      monsters.stream().map(Monster::getHealth).forEach(h -> assertEquals(25, h));
    });
  }
}