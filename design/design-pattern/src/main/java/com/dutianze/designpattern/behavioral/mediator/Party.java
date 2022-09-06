package com.dutianze.designpattern.behavioral.mediator;

import com.dutianze.designpattern.behavioral.mediator.iml.Action;
import com.dutianze.designpattern.behavioral.mediator.memeber.PartyMember;

/**
 * 飞行器驾驶员之间不会通过相互沟通来决定下一架降落的飞机。 所有沟通都通过控制塔台进行。
 *
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li>All scheduleXXX() methods of <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html">java.util.Timer</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html#execute-java.lang.Runnable-">java.util.concurrent.Executor#execute()</a></li>
 * <li>submit() and invokeXXX() methods of <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html">java.util.concurrent.ExecutorService</a></li>
 * <li>scheduleXXX() methods of <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html">java.util.concurrent.ScheduledExecutorService</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html#invoke-java.lang.Object-java.lang.Object...-">java.lang.reflect.Method#invoke()</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
public interface Party {

    void addMember(PartyMember member);

    void act(PartyMember actor, Action action);
}