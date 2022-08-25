package com.dutianze.designpattern.others.sharding;

import com.dutianze.designpattern.others.sharding.impl.LookupShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author dutianze
 * @date 2022/8/25
 */
public class LookupShardManagerTest {

    private LookupShardManager lookupShardManager;

    @BeforeEach
    public void setup() {
        lookupShardManager = new LookupShardManager();
        Shard shard1 = new Shard(1);
        Shard shard2 = new Shard(2);
        Shard shard3 = new Shard(3);
        lookupShardManager.addNewShard(shard1);
        lookupShardManager.addNewShard(shard2);
        lookupShardManager.addNewShard(shard3);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testStoreData() {
        try {
            Data data = new Data(1, "test", Data.DataType.TYPE_1);
            lookupShardManager.storeData(data);
            Field field = LookupShardManager.class.getDeclaredField("lookupMap");
            field.setAccessible(true);
            Map<Integer, Integer> lookupMap = (Map<Integer, Integer>) field.get(lookupShardManager);
            Integer shardId = lookupMap.get(1);
            Shard shard = lookupShardManager.getShardById(shardId);
            assertEquals(data, shard.getDataById(1));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Fail to modify field access.");
        }
    }
}
