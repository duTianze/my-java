package com.dutianze.designpattern.others.eventaggregator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.eventaggregator.emitter.EventEmitter;
import com.dutianze.designpattern.others.eventaggregator.emitter.KingsHand;
import com.dutianze.designpattern.others.eventaggregator.emitter.LordBaelish;
import com.dutianze.designpattern.others.eventaggregator.emitter.LordVarys;
import com.dutianze.designpattern.others.eventaggregator.emitter.Scout;
import com.dutianze.designpattern.others.eventaggregator.enums.Event;
import com.dutianze.designpattern.others.eventaggregator.enums.Weekday;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/12
 */
class KingTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      King king = new King();

      KingsHand kingsHand = new KingsHand();
      kingsHand.registerObserver(king, Event.TRAITOR_DETECTED);
      kingsHand.registerObserver(king, Event.STARK_SIGHTED);
      kingsHand.registerObserver(king, Event.WARSHIPS_APPROACHING);
      kingsHand.registerObserver(king, Event.WHITE_WALKERS_SIGHTED);

      LordVarys varys = new LordVarys();
      varys.registerObserver(kingsHand, Event.TRAITOR_DETECTED);
      varys.registerObserver(kingsHand, Event.WHITE_WALKERS_SIGHTED);

      Scout scout = new Scout();
      scout.registerObserver(kingsHand, Event.WARSHIPS_APPROACHING);
      scout.registerObserver(varys, Event.WHITE_WALKERS_SIGHTED);

      var baelish = new LordBaelish(kingsHand, Event.STARK_SIGHTED);

      var emitters = List.of(
          kingsHand,
          baelish,
          varys,
          scout
      );

      Arrays.stream(Weekday.values())
          .<Consumer<? super EventEmitter>>map(day -> emitter -> emitter.timePasses(day))
          .forEach(emitters::forEach);
    });
  }
}