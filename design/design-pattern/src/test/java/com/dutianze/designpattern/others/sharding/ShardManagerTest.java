package com.dutianze.designpattern.others.sharding;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.sharding.impl.HashShardManager;
import com.dutianze.designpattern.others.sharding.impl.LookupShardManager;
import com.dutianze.designpattern.others.sharding.impl.RangeShardManager;
import com.dutianze.designpattern.others.sharding.model.Data;
import com.dutianze.designpattern.others.sharding.model.Shard;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/25
 */
class ShardManagerTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      Data data1 = new Data(1, "data1", Data.DataType.TYPE_1);
      Data data2 = new Data(2, "data2", Data.DataType.TYPE_2);
      Data data3 = new Data(3, "data3", Data.DataType.TYPE_3);
      Data data4 = new Data(4, "data4", Data.DataType.TYPE_1);

      Shard shard1 = new Shard(1);
      Shard shard2 = new Shard(2);
      Shard shard3 = new Shard(3);

      ShardManager manager = new LookupShardManager();
      manager.addNewShard(shard1);
      manager.addNewShard(shard2);
      manager.addNewShard(shard3);
      manager.storeData(data1);
      manager.storeData(data2);
      manager.storeData(data3);
      manager.storeData(data4);

      shard1.clearData();
      shard2.clearData();
      shard3.clearData();

      ShardManager rangeShardManager = new RangeShardManager();
      rangeShardManager.addNewShard(shard1);
      rangeShardManager.addNewShard(shard2);
      rangeShardManager.addNewShard(shard3);
      rangeShardManager.storeData(data1);
      rangeShardManager.storeData(data2);
      rangeShardManager.storeData(data3);
      rangeShardManager.storeData(data4);

      shard1.clearData();
      shard2.clearData();
      shard3.clearData();

      ShardManager hashShardManager = new HashShardManager();
      hashShardManager.addNewShard(shard1);
      hashShardManager.addNewShard(shard2);
      hashShardManager.addNewShard(shard3);
      hashShardManager.storeData(data1);
      hashShardManager.storeData(data2);
      hashShardManager.storeData(data3);
      hashShardManager.storeData(data4);

      shard1.clearData();
      shard2.clearData();
      shard3.clearData();
    });
  }
}