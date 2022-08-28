package com.dutianze.designpattern.others.saga.orchestration.common;

import com.dutianze.designpattern.others.saga.orchestration.OrchestrationChapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.dutianze.designpattern.others.saga.orchestration.common.Saga.Result.*;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class SagaOrchestrator {

    private final Saga saga;
    private final ServiceDiscoveryService sd;
    private final CurrentState state;

    public SagaOrchestrator(Saga saga, ServiceDiscoveryService sd) {
        this.saga = saga;
        this.sd = sd;
        this.state = new CurrentState();
    }

    @SuppressWarnings("unchecked")
    public <K> Saga.Result execute(K value) {
        state.cleanUp();
        log.info(" The new saga is about to start");
        Saga.Result result = FINISHED;
        K tempVal = value;

        while (true) {
            int next = state.current();
            Saga.Chapter ch = saga.get(next);
            Optional<OrchestrationChapter<?>> srvOpt = sd.find(ch.name);

            if (srvOpt.isEmpty()) {
                state.directionToBack();
                state.back();
                continue;
            }
            OrchestrationChapter srv = srvOpt.get();
            if (state.isForward()) {
                ChapterResult<?> processRes = srv.process(tempVal);
                if (processRes.isSuccess()) {
                    next = state.forward();
                    tempVal = (K) processRes.getValue();
                } else {
                    state.directionToBack();
                }
            } else {
                ChapterResult rlRes = srv.rollback(tempVal);
                if (rlRes.isSuccess()) {
                    next = state.back();
                    tempVal = (K) rlRes.getValue();
                } else {
                    result = CRASHED;
                    next = state.back();
                }
            }

            if (!saga.isPresent(next)) {
                return state.isForward() ? FINISHED : result == CRASHED ? CRASHED : ROLLBACK;
            }
        }
    }

    private static class CurrentState {
        int currentNumber;
        boolean isForward;

        void cleanUp() {
            currentNumber = 0;
            isForward = true;
        }

        CurrentState() {
            this.currentNumber = 0;
            this.isForward = true;
        }

        boolean isForward() {
            return isForward;
        }

        void directionToBack() {
            isForward = false;
        }

        int forward() {
            return ++currentNumber;
        }

        int back() {
            return --currentNumber;
        }

        int current() {
            return currentNumber;
        }
    }

}
