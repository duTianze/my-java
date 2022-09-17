package com.dutianze.designpattern.others.databus;

import com.dutianze.designpattern.others.databus.data.DataType;
import com.dutianze.designpattern.others.databus.memeber.Member;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dutianze
 * @date 2022/9/17
 */
public class DataBus {

  private static final DataBus INSTANCE = new DataBus();

  private final Set<Member> listeners = new HashSet<>();

  public static DataBus getInstance() {
    return INSTANCE;
  }

  public void subscribe(final Member member) {
    this.listeners.add(member);
  }

  public void unsubscribe(final Member member) {
    this.listeners.remove(member);
  }

  public void publish(final DataType event) {
    event.setDataBus(this);
    listeners.forEach(listener -> listener.accept(event));
  }
}
