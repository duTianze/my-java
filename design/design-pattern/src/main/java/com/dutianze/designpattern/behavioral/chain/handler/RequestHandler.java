package com.dutianze.designpattern.behavioral.chain.handler;

import com.dutianze.designpattern.behavioral.chain.request.Request;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
@AllArgsConstructor
public abstract class RequestHandler {

  private final RequestHandler next;

  public void handleRequest(Request req) {
    if (next != null) {
      next.handleRequest(req);
    }
  }

  protected void printHandling(Request req) {
    log.info("{} handling request \"{}\"", this, req);
  }

  @Override
  public abstract String toString();
}
