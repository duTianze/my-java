package com.dutianze.designpattern.others.saga.orchestration.impl;

import com.dutianze.designpattern.others.saga.orchestration.common.ChapterResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class HotelBookingService extends Service<String> {

    @Override
    public String getName() {
        return "booking a Hotel";
    }

    @Override
    public ChapterResult<String> rollback(String value) {
        if (value.equals("crashed_order")) {
            log.info("The Rollback for a chapter '{}' has been started. "
                     + "The data {} has been failed.The saga has been crashed.", getName(), value);
            return ChapterResult.failure(value);
        }
        log.info("The Rollback for a chapter '{}' has been started. "
                 + "The data {} has been rollbacked successfully", getName(), value);
        return super.rollback(value);
    }
}
