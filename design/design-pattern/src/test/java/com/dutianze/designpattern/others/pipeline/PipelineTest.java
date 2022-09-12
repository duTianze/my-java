package com.dutianze.designpattern.others.pipeline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dutianze.designpattern.others.pipeline.handler.impl.ConvertToCharArrayHandler;
import com.dutianze.designpattern.others.pipeline.handler.impl.RemoveAlphabetsHandler;
import com.dutianze.designpattern.others.pipeline.handler.impl.RemoveDigitsHandler;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/4
 */
class PipelineTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      Pipeline<String, char[]> filters =
          new Pipeline<>(new RemoveAlphabetsHandler())
              .addHandler(new RemoveDigitsHandler())
              .addHandler(new ConvertToCharArrayHandler());
      char[] execute = filters.execute("GoYankees123!");
      assertEquals('!', execute[0]);
    });
  }

  @Test
  void testAddHandlersToPipeline() {
    Pipeline<String, char[]> filters =
        new Pipeline<>(new RemoveAlphabetsHandler())
            .addHandler(new RemoveDigitsHandler())
            .addHandler(new ConvertToCharArrayHandler());

    assertArrayEquals(
        new char[]{'#', '!', '(', '&', '%', '#', '!'},
        filters.execute("#H!E(L&L0O%THE3R#34E!")
    );
  }
}