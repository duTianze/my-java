package com.dutianze.designpattern.others.eventasynchronous;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public interface ThreadCompleteListener {

  void completedEventHandler(final int eventId);
}
