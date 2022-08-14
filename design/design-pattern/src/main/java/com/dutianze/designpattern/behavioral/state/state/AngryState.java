package com.dutianze.designpattern.behavioral.state.state;

import com.dutianze.designpattern.behavioral.state.State;
import com.dutianze.designpattern.behavioral.state.context.Mammoth;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class AngryState implements State {

    private final Mammoth mammoth;

    public AngryState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void observe() {
        log.info("{} is furious!", mammoth);
    }

    @Override
    public void onEnterState() {
        log.info("{} gets angry!", mammoth);
    }
}