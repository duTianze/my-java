package com.dutianze.designpattern.others.resourceautoclose;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class SlidingDoor implements AutoCloseable {

    public SlidingDoor() {
        log.info("Sliding door opens.");
    }

    @Override
    public void close() {
        log.info("Sliding door closes.");
    }
}
