package com.dutianze.designpattern.concurrency.queueload.reducer;

import com.dutianze.designpattern.concurrency.queueload.Message;

/**
 * @author dutianze
 * @date 2022/8/30
 */
public interface Task {

  void submit(Message msg);
}
