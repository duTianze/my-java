package com.dutianze.lambda.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/5/4
 */
class OthersTest {

    private Map<Integer, String> map;

    @BeforeEach
    void before() {
        map = new HashMap<>() {{
            put(1, "one");
            put(2, "two");
            put(3, "three");
        }};
    }

    @Test
    void getOrDefault() {
        // get default value when absent
        Assertions.assertEquals("NoValue", map.getOrDefault(11, "NoValue"));

        // get map value when exist
        Assertions.assertEquals("one", map.getOrDefault(1, "NoValue"));
    }

    @Test
    void putIfAbsent() {
        // success put when absent
        Assertions.assertNull(map.putIfAbsent(4, "four"));
        Assertions.assertEquals("four", map.get(4));

        // fail put when exist
        Assertions.assertEquals("one", map.putIfAbsent(1, "four"));
        Assertions.assertEquals("one", map.get(1));
    }

    @Test
    void remove() {
        // remove exist map successful
        Assertions.assertTrue(map.remove(1, "one"));

        // remove absent map failing
        Assertions.assertFalse(map.remove(1, "two"));
    }

    @Test
    void replace() {
        // replace exist map successful
        Assertions.assertEquals("one", map.replace(1, "one one"));

        // replace absent map failing
        Assertions.assertNull(map.replace(11, "one one"));
    }

    @Test
    void name() {
    }

    @Test
    void merge() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("key1", new ArrayList<>(List.of("AAA")));
        // key1が存在すれば"CCC"をListに追加、存在しなければ"BBB"という要素を持ったListを追加
        map.merge("key1", new ArrayList<>(List.of("BBB")),
                  (v1, v2) -> {
                      v1.add("CCC");
                      return v1;
                  });
        Assertions.assertTrue(map.get("key1").contains("CCC"));
    }
}