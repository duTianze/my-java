package com.dutianze.designpattern.others.queueload.reducer;

import com.dutianze.designpattern.others.queueload.Message;

/**
 * @author dutianze
 * @date 2022/8/30
 */
public interface Task {

    void submit(Message msg);
}
