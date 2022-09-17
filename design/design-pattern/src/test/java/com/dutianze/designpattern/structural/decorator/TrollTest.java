package com.dutianze.designpattern.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.dutianze.designpattern.structural.decorator.troll.ClubbedTroll;
import com.dutianze.designpattern.structural.decorator.troll.SimpleTroll;
import com.dutianze.designpattern.utils.InMemoryAppender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
class TrollTest {

  private InMemoryAppender appender;

  @BeforeEach
  void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  void tearDown() {
    appender.stop();
  }


  @Test
  void usage() {
    // simple troll
    log.info("A simple looking troll approaches.");
    var troll = new SimpleTroll();
    troll.attack();
    troll.fleeBattle();
    log.info("Simple troll power: {}.\n", troll.getAttackPower());

    // change the behavior of the simple troll by adding a decorator
    log.info("A troll with huge club surprises you.");
    var clubbedTroll = new ClubbedTroll(troll);
    clubbedTroll.attack();
    clubbedTroll.fleeBattle();
    log.info("Clubbed troll power: {}.\n", clubbedTroll.getAttackPower());
  }

  @Test
  void testTrollActions() {
    final Troll troll = new SimpleTroll();
    assertEquals(10, troll.getAttackPower());

    troll.attack();
    assertEquals("The troll tries to grab you!", appender.getLastMessage());

    troll.fleeBattle();
    assertEquals("The troll shrieks in horror and runs away!", appender.getLastMessage());
    assertEquals(2, appender.getLogSize());
  }

  @Test
  void testClubbedTroll() {
    final Troll simpleTroll = spy(new SimpleTroll());

    final Troll clubbed = new ClubbedTroll(simpleTroll);
    assertEquals(20, clubbed.getAttackPower());
    verify(simpleTroll, times(1)).getAttackPower();

    clubbed.attack();
    verify(simpleTroll, times(1)).attack();

    clubbed.fleeBattle();
    verify(simpleTroll, times(1)).fleeBattle();
    verifyNoMoreInteractions(simpleTroll);
  }
}