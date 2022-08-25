package com.dutianze.designpattern.others.sharding;

import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/25
 */
@Slf4j
public abstract class ShardManager {

    protected Map<Integer, Shard> shardMap;

    public ShardManager() {
        shardMap = new HashMap<>();
    }

    public boolean addNewShard(final Shard shard) {
        int shardId = shard.getId();
        if (!shardMap.containsKey(shardId)) {
            shardMap.put(shardId, shard);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeShardById(final int shardId) {
        if (shardMap.containsKey(shardId)) {
            shardMap.remove(shardId);
            return true;
        } else {
            return false;
        }
    }

    public Shard getShardById(final int shardId) {
        return shardMap.get(shardId);
    }

    public abstract int storeData(final Data data);

    protected abstract int allocateShard(final Data data);

}
