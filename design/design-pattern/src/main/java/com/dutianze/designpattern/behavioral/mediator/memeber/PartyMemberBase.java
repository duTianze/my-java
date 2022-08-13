package com.dutianze.designpattern.behavioral.mediator.memeber;

import com.dutianze.designpattern.behavioral.mediator.Party;
import com.dutianze.designpattern.behavioral.mediator.iml.Action;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public abstract class PartyMemberBase implements PartyMember {

    protected Party party;

    @Override
    public void joinedParty(Party party) {
        log.info("{} joins the party", this);
        this.party = party;
    }

    @Override
    public void partyAction(Action action) {
        log.info("{} {}", this, action.getDescription());
    }

    @Override
    public void act(Action action) {
        if (party != null) {
            log.info("{} {}", this, action);
            party.act(this, action);
        }
    }

    @Override
    public abstract String toString();
}