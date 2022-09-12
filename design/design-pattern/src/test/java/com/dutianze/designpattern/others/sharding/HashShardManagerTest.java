package com.dutianze.designpattern.others.sharding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dutianze.designpattern.others.sharding.impl.HashShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/25
 */
public class HashShardManagerTest {

  private HashShardManager hashShardManager;

  @BeforeEach
  public void setup() {
    hashShardManager = new HashShardManager();
    Shard shard1 = new Shard(1);
    Shard shard2 = new Shard(2);
    Shard shard3 = new Shard(3);
    hashShardManager.addNewShard(shard1);
    hashShardManager.addNewShard(shard2);
    hashShardManager.addNewShard(shard3);
  }

  @Test
  void testStoreData() {
    Data data = new Data(1, "test", Data.DataType.TYPE_1);
    hashShardManager.storeData(data);
    assertEquals(data, hashShardManager.getShardById(1).getDataById(1));
  }

}
