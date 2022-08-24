package com.dutianze.designpattern.others.specialcase.domain;

import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public interface DomainServices {

    ReceiptViewModel purchase(String userName, String itemName);
}
