package com.dutianze.designpattern.others.databus;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import com.dutianze.designpattern.others.databus.data.DataType;
import com.dutianze.designpattern.others.databus.data.impl.MessageData;
import com.dutianze.designpattern.others.databus.data.impl.StartingData;
import com.dutianze.designpattern.others.databus.data.impl.StoppingData;
import com.dutianze.designpattern.others.databus.memeber.Member;
import com.dutianze.designpattern.others.databus.memeber.MessageCollectorMember;
import com.dutianze.designpattern.others.databus.memeber.StatusMember;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author dutianze
 * @date 2022/9/17
 */
class DataBusTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      final DataBus bus = DataBus.getInstance();
      bus.subscribe(new StatusMember(1));
      bus.subscribe(new StatusMember(2));
      final MessageCollectorMember foo = new MessageCollectorMember("Foo");
      final MessageCollectorMember bar = new MessageCollectorMember("Bar");

      bus.subscribe(foo);
      bus.publish(StartingData.of(LocalDateTime.now()));
      bus.publish(MessageData.of("Only Foo should see this"));

      bus.subscribe(bar);
      bus.publish(MessageData.of("Foo and Bar should see this"));

      bus.unsubscribe(foo);
      bus.publish(MessageData.of("Only Bar should see this"));
      bus.publish(StoppingData.of(LocalDateTime.now()));
    });
  }

  @Mock
  private Member member;
  @Mock
  private DataType event;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void publishedEventIsReceivedBySubscribedMember() {
    //given
    final DataBus dataBus = DataBus.getInstance();
    dataBus.subscribe(member);
    //when
    dataBus.publish(event);
    //then
    then(member).should().accept(event);
  }

  @Test
  void publishedEventIsNotReceivedByMemberAfterUnsubscribing() {
    //given
    final DataBus dataBus = DataBus.getInstance();
    dataBus.subscribe(member);
    dataBus.unsubscribe(member);
    //when
    dataBus.publish(event);
    //then
    then(member).should(never()).accept(event);
  }
}