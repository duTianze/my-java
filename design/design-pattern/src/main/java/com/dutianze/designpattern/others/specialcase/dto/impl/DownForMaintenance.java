package com.dutianze.designpattern.others.specialcase.dto.impl;

import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class DownForMaintenance implements ReceiptViewModel {

    @Override
    public void show() {
        log.warn("Down for maintenance");
    }
}
