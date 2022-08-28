package com.dutianze.designpattern.others.saga.orchestration;

import com.dutianze.designpattern.others.saga.orchestration.common.ChapterResult;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public interface OrchestrationChapter<K> {

    String getName();

    ChapterResult<K> process(K value);

    ChapterResult<K> rollback(K value);
}
