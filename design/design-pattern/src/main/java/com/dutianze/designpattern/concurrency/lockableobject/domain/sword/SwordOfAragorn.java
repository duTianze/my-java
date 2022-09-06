package com.dutianze.designpattern.concurrency.lockableobject.domain.sword;

import com.dutianze.designpattern.concurrency.lockableobject.Lockable;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Creature;
import com.dutianze.designpattern.concurrency.lockableobject.domain.exception.LockingException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/6
 */
@Slf4j
public class SwordOfAragorn implements Lockable {

    private Creature locker;
    private final Object synchronizer;
    private static final String NAME = "The Sword of Aragorn";

    public SwordOfAragorn() {
        this.locker = null;
        this.synchronizer = new Object();
    }

    @Override
    public boolean isLocked() {
        return this.locker != null;
    }

    @Override
    public boolean lock(@NonNull Creature creature) {
        synchronized (synchronizer) {
            log.info("{} is now trying to acquire {}!", creature.getName(), this.getName());
            if (!isLocked()) {
                locker = creature;
                return true;
            } else {
                if (!locker.getName().equals(creature.getName())) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void unlock(@NonNull Creature creature) {
        synchronized (synchronizer) {
            if (locker == null) {
                return;
            }
            if (locker.getName().equals(creature.getName())) {
                locker = null;
                log.info("{} is now free!", this.getName());
                return;
            }
            throw new LockingException("You cannot unlock an object you are not the owner of.");
        }
    }

    @Override
    public Creature getLocker() {
        return this.locker;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
