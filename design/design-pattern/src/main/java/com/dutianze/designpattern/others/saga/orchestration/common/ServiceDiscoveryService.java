package com.dutianze.designpattern.others.saga.orchestration.common;

import com.dutianze.designpattern.others.saga.orchestration.OrchestrationChapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class ServiceDiscoveryService {

    private final Map<String, OrchestrationChapter<?>> services;

    public Optional<OrchestrationChapter<?>> find(String service) {
        return Optional.ofNullable(services.getOrDefault(service, null));
    }

    public ServiceDiscoveryService discover(OrchestrationChapter<?> orchestrationChapterService) {
        services.put(orchestrationChapterService.getName(), orchestrationChapterService);
        return this;
    }

    public ServiceDiscoveryService() {
        this.services = new HashMap<>();
    }
}
