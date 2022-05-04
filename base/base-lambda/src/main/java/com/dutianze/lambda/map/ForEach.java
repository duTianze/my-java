package com.dutianze.lambda.map;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author dutianze
 * @date 2022/5/4
 */
public class ForEach {

    public void forLoop(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public void anonymous(Map<Integer, String> map) {
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer key, String value) {
                System.out.println(key + "=" + value);
            }
        });
    }

    public void lambda(Map<Integer, String> map) {
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }
}
