package com.dutianze.designpattern.others.saga.choreography.common;

import com.dutianze.designpattern.others.saga.choreography.ChoreographyChapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class ServiceDiscoveryService {

    private final Map<String, ChoreographyChapter> services;

    public ChoreographyChapter findAny() {
        return services.values().iterator().next();
    }

    public Optional<ChoreographyChapter> find(String service) {
        return Optional.ofNullable(services.getOrDefault(service, null));
    }

    public ServiceDiscoveryService discover(ChoreographyChapter chapterService) {
        services.put(chapterService.getName(), chapterService);
        return this;
    }

    public ServiceDiscoveryService() {
        this.services = new HashMap<>();
    }
}
