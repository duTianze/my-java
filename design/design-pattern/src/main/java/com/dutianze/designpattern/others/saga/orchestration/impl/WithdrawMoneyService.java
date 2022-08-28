package com.dutianze.designpattern.others.saga.orchestration.impl;

import com.dutianze.designpattern.others.saga.orchestration.common.ChapterResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class WithdrawMoneyService extends Service<String> {
    @Override
    public String getName() {
        return "withdrawing Money";
    }

    @Override
    public ChapterResult<String> process(String value) {
        if (value.equals("bad_order") || value.equals("crashed_order")) {
            log.info("The chapter '{}' has been started. But the exception has been raised."
                     + "The rollback is about to start {}", getName(), value);
            return ChapterResult.failure(value);
        }
        return super.process(value);
    }
}
