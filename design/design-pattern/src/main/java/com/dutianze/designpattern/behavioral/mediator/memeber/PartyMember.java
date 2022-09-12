package com.dutianze.designpattern.behavioral.mediator.memeber;

import com.dutianze.designpattern.behavioral.mediator.Party;
import com.dutianze.designpattern.behavioral.mediator.iml.Action;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public interface PartyMember {

  void joinedParty(Party party);

  void partyAction(Action action);

  void act(Action action);
}