package com.dutianze.designpattern.behavioral.mediator.iml;

import com.dutianze.designpattern.behavioral.mediator.Party;
import com.dutianze.designpattern.behavioral.mediator.memeber.PartyMember;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class PartyImpl implements Party {

  private final List<PartyMember> members;

  public PartyImpl() {
    members = new ArrayList<>();
  }

  @Override
  public void act(PartyMember actor, Action action) {
    members.stream()
        .filter(member -> !member.equals(actor))
        .forEach(member -> member.partyAction(action));
  }

  @Override
  public void addMember(PartyMember member) {
    members.add(member);
    member.joinedParty(this);
  }
}