package com.dutianze.designpattern.others.sharding.impl;

import com.dutianze.designpattern.others.sharding.ShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/25
 */
@Slf4j
public class RangeShardManager extends ShardManager {

    @Override
    public int storeData(Data data) {
        int shardId = allocateShard(data);
        Shard shard = shardMap.get(shardId);
        shard.storeData(data);
        log.info(data + " is stored in Shard " + shardId);
        return shardId;
    }

    @Override
    protected int allocateShard(Data data) {
        Data.DataType type = data.getType();
        return switch (type) {
            case TYPE_1 -> 1;
            case TYPE_2 -> 2;
            case TYPE_3 -> 3;
        };
    }

}
