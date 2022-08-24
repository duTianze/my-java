package com.dutianze.designpattern.others.specialcase.impl;

import com.dutianze.designpattern.others.specialcase.ApplicationServices;
import com.dutianze.designpattern.others.specialcase.domain.DomainServices;
import com.dutianze.designpattern.others.specialcase.domain.MaintenanceLock;
import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import com.dutianze.designpattern.others.specialcase.dto.impl.DownForMaintenance;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class ApplicationServicesImpl implements ApplicationServices {

    private final DomainServices domain = new DomainServicesImpl();

    @Override
    public ReceiptViewModel loggedInUserPurchase(String userName, String itemName) {
        if (isDownForMaintenance()) {
            return new DownForMaintenance();
        }
        return domain.purchase(userName, itemName);
    }

    private boolean isDownForMaintenance() {
        return MaintenanceLock.getInstance().isLock();
    }
}
