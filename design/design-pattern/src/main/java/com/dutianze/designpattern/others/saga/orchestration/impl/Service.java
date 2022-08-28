package com.dutianze.designpattern.others.saga.orchestration.impl;

import com.dutianze.designpattern.others.saga.orchestration.OrchestrationChapter;
import com.dutianze.designpattern.others.saga.orchestration.common.ChapterResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public abstract class Service<K> implements OrchestrationChapter<K> {

    @Override
    public abstract String getName();


    @Override
    public ChapterResult<K> process(K value) {
        log.info("The chapter '{}' has been started. "
                 + "The data {} has been stored or calculated successfully", getName(), value);
        return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<K> rollback(K value) {
        log.info("The Rollback for a chapter '{}' has been started. "
                 + "The data {} has been rollbacked successfully", getName(), value);
        return ChapterResult.success(value);
    }
}
