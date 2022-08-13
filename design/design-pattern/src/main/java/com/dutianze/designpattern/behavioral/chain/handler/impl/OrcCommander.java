package com.dutianze.designpattern.behavioral.chain.handler.impl;

import com.dutianze.designpattern.behavioral.chain.handler.RequestHandler;
import com.dutianze.designpattern.behavioral.chain.request.Request;
import com.dutianze.designpattern.behavioral.chain.request.RequestType;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class OrcCommander extends RequestHandler {

    public OrcCommander(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (RequestType.DEFEND_CASTLE == req.getRequestType()) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}