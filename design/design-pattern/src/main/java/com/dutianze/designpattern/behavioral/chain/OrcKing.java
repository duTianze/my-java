package com.dutianze.designpattern.behavioral.chain;

import com.dutianze.designpattern.behavioral.chain.handler.RequestHandler;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcCommander;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcOfficer;
import com.dutianze.designpattern.behavioral.chain.handler.impl.OrcSoldier;
import com.dutianze.designpattern.behavioral.chain.request.Request;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html#log%28java.util.logging.Level,%20java.lang.String%29">java.util.logging.Logger#log()</a></li>
 * <li><a href="https://commons.apache.org/proper/commons-chain/index.html">Apache Commons Chain</a></li>
 * <li><a href="http://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-">javax.servlet.Filter#doFilter()</a></li>
 * </ul>
 *
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