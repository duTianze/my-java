package com.dutianze.designpattern.others.servicelocator.common;

import com.dutianze.designpattern.others.servicelocator.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Slf4j
public class InitContext {

    public Object lookup(String serviceName) {
        if (serviceName.equals("jndi/serviceA")) {
            log.info("Looking up service A and creating new service for A");
            return new ServiceImpl("jndi/serviceA");
        } else if (serviceName.equals("jndi/serviceB")) {
            log.info("Looking up service B and creating new service for B");
            return new ServiceImpl("jndi/serviceB");
        } else {
            return null;
        }
    }
}
