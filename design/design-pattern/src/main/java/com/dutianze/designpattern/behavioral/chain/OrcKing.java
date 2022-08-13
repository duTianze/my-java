package com.dutianze.designpattern.behavioral.chain;

import com.dutianze.designpattern.behavioral.chain.handler.RequestHandler;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcCommander;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcOfficer;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcSoldier;
import com.dutianze.designpattern.behavioral.chain.request.Request;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class OrcKing {

    private RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}