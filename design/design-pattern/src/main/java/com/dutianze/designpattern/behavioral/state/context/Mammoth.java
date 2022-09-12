package com.dutianze.designpattern.behavioral.state.context;

import com.dutianze.designpattern.behavioral.state.State;
import com.dutianze.designpattern.behavioral.state.state.AngryState;
import com.dutianze.designpattern.behavioral.state.state.PeacefulState;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class Mammoth {

  private State state;

  public Mammoth() {
    state = new PeacefulState(this);
  }

  public void timePasses() {
    if (state.getClass().equals(PeacefulState.class)) {
      changeStateTo(new AngryState(this));
    } else {
      changeStateTo(new PeacefulState(this));
    }
  }

  private void changeStateTo(State newState) {
    this.state = newState;
    this.state.onEnterState();
  }

  public void observe() {
    this.state.observe();
  }

  @Override
  public String toString() {
    return "The mammoth";
  }
}