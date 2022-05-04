package com.dutianze.lambda.collection;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author dutianze
 * @date 2022/5/3
 */
public class ReplaceAll {

    public List<String> forLoop(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() > 3) {
                list.set(i, s.toUpperCase());
            }
        }
        return list;
    }

    public List<String> anonymous(List<String> list) {
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.length() > 3) {
                    return s.toUpperCase();
                }
                return s;
            }
        });
        return list;
    }

    public List<String> lambda(List<String> list) {
        list.replaceAll(s -> {
            if (s.length() > 3) {
                return s.toUpperCase();
            }
            return s;
        });
        return list;
    }
}
