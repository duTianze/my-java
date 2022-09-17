package com.dutianze.designpattern.others.databus.memeber;

import com.dutianze.designpattern.others.databus.data.DataType;
import com.dutianze.designpattern.others.databus.data.impl.MessageData;
import com.dutianze.designpattern.others.databus.data.impl.StartingData;
import com.dutianze.designpattern.others.databus.data.impl.StoppingData;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Getter
@Slf4j
@RequiredArgsConstructor
public class StatusMember implements Member {

  private final int id;

  private LocalDateTime started;

  private LocalDateTime stopped;

  @Override
  public void accept(final DataType data) {
    if (data instanceof StartingData startingData) {
      handleEvent(startingData);
    } else if (data instanceof StoppingData stoppingData) {
      handleEvent(stoppingData);
    }
  }

  private void handleEvent(StartingData data) {
    started = data.getWhen();
    log.info("Receiver {} sees application started at {}", id, started);
  }

  private void handleEvent(StoppingData data) {
    stopped = data.getWhen();
    log.info("Receiver {} sees application stopping at {}", id, stopped);
    log.info("Receiver {} sending goodbye message", id);
    data.getDataBus().publish(MessageData.of(String.format("Goodbye cruel world from #%d!", id)));
  }
}
