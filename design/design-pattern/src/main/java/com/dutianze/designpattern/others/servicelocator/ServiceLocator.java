package com.dutianze.designpattern.others.servicelocator;

import com.dutianze.designpattern.others.servicelocator.common.InitContext;
import com.dutianze.designpattern.others.servicelocator.common.ServiceCache;
import com.dutianze.designpattern.others.servicelocator.service.Service;

/**
 * @author dutianze
 * @date 2022/8/27
 */
public final class ServiceLocator {

    private static final ServiceCache serviceCache = new ServiceCache();

    private ServiceLocator() {
    }

    public static Service getService(String serviceJndiName) {
        Service serviceObj = serviceCache.getService(serviceJndiName);
        if (serviceObj != null) {
            return serviceObj;
        }
        InitContext ctx = new InitContext();
        serviceObj = (Service) ctx.lookup(serviceJndiName);
        if (serviceObj != null) {
            serviceCache.addService(serviceObj);
        }
        return serviceObj;
    }
}
