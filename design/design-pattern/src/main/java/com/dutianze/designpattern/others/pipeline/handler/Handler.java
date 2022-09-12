package com.dutianze.designpattern.others.pipeline.handler;

/**
 * @author dutianze
 * @date 2022/9/4
 */
public interface Handler<I, O> {

  O process(I input);
}
