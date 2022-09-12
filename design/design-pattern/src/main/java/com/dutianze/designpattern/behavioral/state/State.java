package com.dutianze.designpattern.behavioral.state;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javaee/7/api/javax/faces/lifecycle/Lifecycle.html#execute-javax.faces.context.FacesContext-">javax.faces.lifecycle.Lifecycle#execute()</a> controlled by <a href="http://docs.oracle.com/javaee/7/api/javax/faces/webapp/FacesServlet.html">FacesServlet</a>, the behavior is dependent on current phase of lifecycle.</li>
 * <li><a href="https://github.com/npathai/jdiameter/blob/master/core/jdiameter/api/src/main/java/org/jdiameter/api/app/State.java">JDiameter - Diameter State Machine</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
public interface State {

  void onEnterState();

  void observe();
}