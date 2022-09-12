package com.dutianze.designpattern.others.specialcase;

import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public interface ApplicationServices {

  ReceiptViewModel loggedInUserPurchase(String userName, String itemName);
}
