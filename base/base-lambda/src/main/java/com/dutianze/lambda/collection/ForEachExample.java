package com.dutianze.lambda.collection;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author dutianze
 * @date 2022/5/3
 */
public class ForEachExample {

    public void justFor(List<String> list) {
        for (String s : list) {
            if (s.length() > 3) {
                System.out.println(s);
            }
        }
    }

    public void anonymous(List<String> list) {
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3) {
                    System.out.println(s);
                }
            }
        });
    }

    public void lambda(List<String> list) {
        list.forEach(s -> {
            if (s.length() > 3) {
                System.out.println(s);
            }
        });
    }
}
