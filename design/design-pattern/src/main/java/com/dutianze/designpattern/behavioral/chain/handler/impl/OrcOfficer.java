package com.dutianze.designpattern.behavioral.chain.handler.impl;

import com.dutianze.designpattern.behavioral.chain.handler.RequestHandler;
import com.dutianze.designpattern.behavioral.chain.request.Request;
import com.dutianze.designpattern.behavioral.chain.request.RequestType;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class OrcOfficer extends RequestHandler {

  public OrcOfficer(RequestHandler handler) {
    super(handler);
  }

  @Override
  public void handleRequest(Request req) {
    if (RequestType.TORTURE_PRISONER == req.getRequestType()) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "Orc officer";
  }
}