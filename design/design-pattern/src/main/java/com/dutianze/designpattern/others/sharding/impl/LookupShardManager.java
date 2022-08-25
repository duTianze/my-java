package com.dutianze.designpattern.others.sharding.impl;

import com.dutianze.designpattern.others.sharding.ShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/25
 */
@Slf4j
public class LookupShardManager extends ShardManager {

    private final Map<Integer, Integer> lookupMap = new HashMap<>();

    @Override
    public int storeData(Data data) {
        int shardId = allocateShard(data);
        lookupMap.put(data.getKey(), shardId);
        Shard shard = shardMap.get(shardId);
        shard.storeData(data);
        log.info(data + " is stored in Shard " + shardId);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        int key = data.getKey();
        if (lookupMap.containsKey(key)) {
            return lookupMap.get(key);
        } else {
            int shardCount = shardMap.size();
            return new SecureRandom().nextInt(shardCount - 1) + 1;
        }
    }

}
