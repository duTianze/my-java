package com.dutianze.designpattern.behavioral.command;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html">java.lang.Runnable</a></li>
 * <li><a href="https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/runners/model/Statement.java">org.junit.runners.model.Statement</a></li>
 * <li><a href="https://github.com/Netflix/Hystrix/wiki">Netflix Hystrix</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/swing/Action.html">javax.swing.Action</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class Wizard {

    private final Deque<Runnable> undoStack = new LinkedList<>();
    private final Deque<Runnable> redoStack = new LinkedList<>();

    public void castSpell(Runnable runnable) {
        runnable.run();
        undoStack.offerLast(runnable);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Runnable previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Runnable previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}