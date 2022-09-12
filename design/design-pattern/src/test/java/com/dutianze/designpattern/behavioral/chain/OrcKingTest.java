package com.dutianze.designpattern.behavioral.chain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dutianze.designpattern.behavioral.chain.request.Request;
import com.dutianze.designpattern.behavioral.chain.request.RequestType;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class OrcKingTest {

  private static final List<Request> REQUESTS = List.of(
      new Request(RequestType.DEFEND_CASTLE, "Don't let the barbarians enter my castle!!"),
      new Request(RequestType.TORTURE_PRISONER, "Don't just stand there, tickle him!"),
      new Request(RequestType.COLLECT_TAX, "Don't steal, the King hates competition ...")
  );

  @Test
  void testMakeRequest() {
    final OrcKing king = new OrcKing();

    REQUESTS.forEach(request -> {
      king.makeRequest(request);
      assertTrue(
          request.isHandled(),
          "Expected all requests from King to be handled, but [" + request + "] was not!"
      );
    });
  }
}