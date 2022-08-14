package com.dutianze.designpattern.behavioral.templatemethod;

import com.dutianze.designpattern.behavioral.templatemethod.stealing.StealingMethod;

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
public class HalflingThief {

    private StealingMethod method;

    public HalflingThief(StealingMethod method) {
        this.method = method;
    }

    public void steal() {
        method.steal();
    }

    public void changeMethod(StealingMethod method) {
        this.method = method;
    }
}