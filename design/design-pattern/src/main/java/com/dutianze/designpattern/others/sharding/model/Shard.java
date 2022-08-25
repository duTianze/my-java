package com.dutianze.designpattern.others.sharding.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/25
 */
public class Shard {

    private final int id;

    private final Map<Integer, Data> dataStore;

    public Shard(final int id) {
        this.id = id;
        this.dataStore = new HashMap<>();
    }

    public void storeData(Data data) {
        dataStore.put(data.getKey(), data);
    }

    public void clearData() {
        dataStore.clear();
    }

    public Data getDataById(final int id) {
        return dataStore.get(id);
    }

    public int getId() {
        return id;
    }

}
