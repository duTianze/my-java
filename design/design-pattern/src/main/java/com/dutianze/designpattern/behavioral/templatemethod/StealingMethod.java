package com.dutianze.designpattern.behavioral.templatemethod;

import lombok.extern.slf4j.Slf4j;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://jakarta.ee/specifications/servlet/4.0/apidocs/javax/servlet/GenericServlet.html#init--">javax.servlet.GenericServlet.init</a>:
 * Method <code>GenericServlet.init(ServletConfig config)</code> calls the parameterless method <code>GenericServlet.init()</code> which is intended to be overridden in subclasses.
 * Method <code>GenericServlet.init(ServletConfig config)</code> is the template method in this example.</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public abstract class StealingMethod {

  protected abstract String pickTarget();

  protected abstract void confuseTarget(String target);

  protected abstract void stealTheItem(String target);

  public void steal() {
    String target = pickTarget();
    log.info("The target has been chosen as {}.", target);
    confuseTarget(target);
    stealTheItem(target);
  }
}
