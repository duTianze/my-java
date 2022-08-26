package com.dutianze.designpattern.others.servicelocator.common;

import com.dutianze.designpattern.others.servicelocator.service.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/27
 */
@Slf4j
public class ServiceCache {

    private final Map<String, Service> serviceCache;

    public ServiceCache() {
        serviceCache = new HashMap<>();
    }

    public Service getService(String serviceName) {
        if (serviceCache.containsKey(serviceName)) {
            Service cachedService = serviceCache.get(serviceName);
            String name = cachedService.getName();
            int id = cachedService.getId();
            log.info("(cache call) Fetched service {}({}) from cache... !", name, id);
            return cachedService;
        }
        return null;
    }

    public void addService(Service newService) {
        serviceCache.put(newService.getName(), newService);
    }
}
