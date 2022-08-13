package com.dutianze.designpattern.structural.facade.impl;

import com.dutianze.designpattern.structural.facade.DwarvenGoldmineFacade;
import com.dutianze.designpattern.structural.facade.dwarven.impl.DwarvenCartOperator;
import com.dutianze.designpattern.structural.facade.dwarven.impl.DwarvenGoldDigger;
import com.dutianze.designpattern.structural.facade.dwarven.DwarvenMineWorker;
import com.dutianze.designpattern.structural.facade.dwarven.impl.DwarvenTunnelDigger;

import java.util.Collection;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class DwarvenGoldmineFacadeImpl implements DwarvenGoldmineFacade {

    private final List<DwarvenMineWorker> workers;

    public DwarvenGoldmineFacadeImpl() {
        workers = List.of(new DwarvenGoldDigger(),
                          new DwarvenCartOperator(),
                          new DwarvenTunnelDigger());
    }

    public void startNewDay() {
        makeActions(workers, DwarvenMineWorker.Action.WAKE_UP, DwarvenMineWorker.Action.GO_TO_MINE);
    }

    public void digOutGold() {
        makeActions(workers, DwarvenMineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(workers, DwarvenMineWorker.Action.GO_HOME, DwarvenMineWorker.Action.GO_TO_SLEEP);
    }

    private static void makeActions(Collection<DwarvenMineWorker> workers, DwarvenMineWorker.Action... actions) {
        workers.forEach(worker -> worker.action(actions));
    }
}
