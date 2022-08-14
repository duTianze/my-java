package com.dutianze.designpattern.behavioral.state.state;

import com.dutianze.designpattern.behavioral.state.State;
import com.dutianze.designpattern.behavioral.state.context.Mammoth;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class PeacefulState implements State {

    private final Mammoth mammoth;

    public PeacefulState(Mammoth mammoth) {
        this.mammoth = mammoth;
    }

    @Override
    public void observe() {
        log.info("{} is calm and peaceful.", mammoth);
    }

    @Override
    public void onEnterState() {
        log.info("{} calms down.", mammoth);
    }
}