package com.dutianze.lambda.collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dutianze
 * @date 2022/5/3
 */
public class RemoveIf {

    public List<String> forLoop(List<String> list) {
        for (String s : list) {
            if (s.length() > 3) {
                list.remove(s);
            }
        }
        return list;
    }

    public List<String> useIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3) {
                iterator.remove();
            }
        }
        return list;
    }

    public List<String> anonymous(List<String> list) {
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });
        return list;
    }

    public List<String> lambda(List<String> list) {
        list.removeIf(s -> s.length() > 3);
        return list;
    }
}
