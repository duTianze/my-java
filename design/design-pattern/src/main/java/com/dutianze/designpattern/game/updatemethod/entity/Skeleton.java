package com.dutianze.designpattern.game.updatemethod.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/18
 */
@Slf4j
public class Skeleton extends Entity {

    private static final int PATROLLING_LEFT_BOUNDING = 0;

    private static final int PATROLLING_RIGHT_BOUNDING = 100;

    @Getter
    @Setter
    protected boolean patrollingLeft;

    public Skeleton(int id) {
        super(id);
        patrollingLeft = false;
    }

    public Skeleton(int id, int position) {
        super(id);
        this.position = position;
        patrollingLeft = false;
    }

    @Override
    public void update() {
        if (patrollingLeft) {
            position -= 1;
            if (position == PATROLLING_LEFT_BOUNDING) {
                patrollingLeft = false;
            }
        } else {
            position += 1;
            if (position == PATROLLING_RIGHT_BOUNDING) {
                patrollingLeft = true;
            }
        }
        log.info("Skeleton {} is on position {}.", id, position);
    }
}