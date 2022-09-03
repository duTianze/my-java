package com.dutianze.designpattern.others.pipeline;

import com.dutianze.designpattern.others.pipeline.handler.Handler;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html">java.util.Stream</a></li>
 * <li><a href="http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html">Maven Build Lifecycle</a></li>
 * <li><a href="https://github.com/functionaljava/functionaljava">Functional Java</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/4
 */
class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    O execute(I input) {
        return currentHandler.process(input);
    }
}
