package com.dutianze.lambda.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/4
 */
public class Sort {

    public List<String> anonymous(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return list;
    }

    public List<String> lambda(List<String> list) {
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }
}
