package com.dutianze.designpattern.others.saga.choreography;

import com.dutianze.designpattern.others.saga.choreography.common.Saga;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public interface ChoreographyChapter {

    Saga execute(Saga saga);

    String getName();

    Saga process(Saga saga);

    Saga rollback(Saga saga);
}

