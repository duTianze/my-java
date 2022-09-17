package com.dutianze.designpattern.others.databus.memeber;

import com.dutianze.designpattern.others.databus.data.DataType;
import com.dutianze.designpattern.others.databus.data.impl.MessageData;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class MessageCollectorMember implements Member {

  private final String name;

  private final List<String> messages = new ArrayList<>();

  public MessageCollectorMember(String name) {
    this.name = name;
  }

  @Override
  public void accept(final DataType data) {
    if (data instanceof MessageData messageData) {
      handleEvent(messageData);
    }
  }

  private void handleEvent(MessageData data) {
    log.info("{} sees message {}", name, data.getMessage());
    messages.add(data.getMessage());
  }

  public List<String> getMessages() {
    return List.copyOf(messages);
  }
}
