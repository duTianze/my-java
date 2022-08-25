package com.dutianze.designpattern.others.sharding;

import com.dutianze.designpattern.others.sharding.impl.RangeShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/25
 */
public class RangeShardManagerTest {

    private RangeShardManager rangeShardManager;

    @BeforeEach
    public void setup() {
        rangeShardManager = new RangeShardManager();
        Shard shard1 = new Shard(1);
        Shard shard2 = new Shard(2);
        Shard shard3 = new Shard(3);
        rangeShardManager.addNewShard(shard1);
        rangeShardManager.addNewShard(shard2);
        rangeShardManager.addNewShard(shard3);
    }

    @Test
    void testStoreData() {
        Data data = new Data(1, "test", Data.DataType.TYPE_1);
        rangeShardManager.storeData(data);
        assertEquals(data, rangeShardManager.getShardById(1).getDataById(1));
    }

}
