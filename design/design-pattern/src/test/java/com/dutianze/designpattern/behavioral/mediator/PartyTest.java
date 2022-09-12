package com.dutianze.designpattern.behavioral.mediator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.dutianze.designpattern.behavioral.mediator.iml.Action;
import com.dutianze.designpattern.behavioral.mediator.iml.PartyImpl;
import com.dutianze.designpattern.behavioral.mediator.memeber.PartyMember;
import com.dutianze.designpattern.behavioral.mediator.memeber.impl.Hobbit;
import com.dutianze.designpattern.behavioral.mediator.memeber.impl.Hunter;
import com.dutianze.designpattern.behavioral.mediator.memeber.impl.Rogue;
import com.dutianze.designpattern.behavioral.mediator.memeber.impl.Wizard;
import com.dutianze.designpattern.utils.InMemoryAppender;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class PartyTest {

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
  void usage() {
    assertDoesNotThrow(() -> {
      // create party and members
      Party party = new PartyImpl();
      PartyMember hobbit = new Hobbit();
      PartyMember wizard = new Wizard();
      PartyMember rogue = new Rogue();
      PartyMember hunter = new Hunter();

      // add party members
      party.addMember(hobbit);
      party.addMember(wizard);
      party.addMember(rogue);
      party.addMember(hunter);

      // perform actions -> the other party members
      // are notified by the party
      hobbit.act(Action.ENEMY);
      wizard.act(Action.TALE);
      rogue.act(Action.GOLD);
      hunter.act(Action.HUNT);
    });
  }

  @ParameterizedTest
  @MethodSource("dataProvider")
  public void testPartyAction(Supplier<PartyMember> memberSupplier) {
    final PartyMember member = memberSupplier.get();

    for (final Action action : Action.values()) {
      member.partyAction(action);
      assertEquals(member + " " + action.getDescription(), appender.getLastMessage());
    }

    assertEquals(Action.values().length, appender.getLogSize());
  }

  @ParameterizedTest
  @MethodSource("dataProvider")
  public void testAct(Supplier<PartyMember> memberSupplier) {
    final PartyMember member = memberSupplier.get();

    member.act(Action.GOLD);
    assertEquals(0, appender.getLogSize());

    final Party party = mock(Party.class);
    member.joinedParty(party);
    assertEquals(member + " joins the party", appender.getLastMessage());

    for (final Action action : Action.values()) {
      member.act(action);
      assertEquals(member + " " + action.toString(), appender.getLastMessage());
      verify(party).act(member, action);
    }

    assertEquals(Action.values().length + 1, appender.getLogSize());
  }

  @ParameterizedTest
  @MethodSource("dataProvider")
  public void testToString(Supplier<PartyMember> memberSupplier) {
    final PartyMember member = memberSupplier.get();
    final Class<? extends PartyMember> memberClass = member.getClass();
    assertEquals(memberClass.getSimpleName(), member.toString());
  }

  @Test
  void testPartyAction() {
    final PartyMember partyMember1 = mock(PartyMember.class);
    final PartyMember partyMember2 = mock(PartyMember.class);

    final PartyImpl party = new PartyImpl();
    party.addMember(partyMember1);
    party.addMember(partyMember2);

    verify(partyMember1).joinedParty(party);
    verify(partyMember2).joinedParty(party);

    party.act(partyMember1, Action.GOLD);
    verifyNoMoreInteractions(partyMember1);
    verify(partyMember2).partyAction(Action.GOLD);

    verifyNoMoreInteractions(partyMember1, partyMember2);
  }

  static Stream<Arguments> dataProvider() {
    return Stream.of(
        Arguments.of((Supplier<PartyMember>) Hobbit::new),
        Arguments.of((Supplier<PartyMember>) Hunter::new),
        Arguments.of((Supplier<PartyMember>) Rogue::new),
        Arguments.of((Supplier<PartyMember>) Wizard::new)
    );
  }
}