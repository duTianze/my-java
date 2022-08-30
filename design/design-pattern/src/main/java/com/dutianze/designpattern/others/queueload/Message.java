package com.dutianze.designpattern.others.queueload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/30
 */
@Getter
@RequiredArgsConstructor
public class Message {
    private final String msg;

    @Override
    public String toString() {
        return msg;
    }
}
