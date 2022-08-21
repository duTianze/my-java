package com.dutianze.designpattern.others.throttling;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Slf4j
public final class CallsCount {

    private final Map<String, AtomicLong> tenantCallsCount = new ConcurrentHashMap<>();

    public void addTenant(String tenantName) {
        tenantCallsCount.putIfAbsent(tenantName, new AtomicLong(0));
    }

    public void incrementCount(String tenantName) {
        tenantCallsCount.get(tenantName).incrementAndGet();
    }

    public long getCount(String tenantName) {
        return tenantCallsCount.get(tenantName).get();
    }

    public void reset() {
        tenantCallsCount.replaceAll((k, v) -> new AtomicLong(0));
        log.info("reset counters");
    }
}
