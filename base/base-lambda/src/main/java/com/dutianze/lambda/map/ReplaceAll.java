package com.dutianze.lambda.map;

import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author dutianze
 * @date 2022/5/4
 */
public class ReplaceAll {

    public void forLoop(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.setValue(entry.getValue().toUpperCase());
        }
    }

    public void anonymous(Map<Integer, String> map) {
        map.replaceAll(new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer key, String value) {
                return value.toUpperCase();
            }
        });
    }

    public void lambda(Map<Integer, String> map) {
        map.replaceAll((key, value) -> value.toUpperCase());
    }}
