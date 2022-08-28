package com.dutianze.designpattern.others.resourceautoclose;

import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class TreasureChest implements Closeable {

    public TreasureChest() {
        log.info("Treasure chest opens.");
    }

    @Override
    public void close() {
        log.info("Treasure chest closes.");
    }
}
