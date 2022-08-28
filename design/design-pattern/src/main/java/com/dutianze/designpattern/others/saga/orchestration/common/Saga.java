package com.dutianze.designpattern.others.saga.orchestration.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class Saga {

    private final List<Chapter> chapters;

    private Saga() {
        this.chapters = new ArrayList<>();
    }

    public Saga chapter(String name) {
        this.chapters.add(new Chapter(name));
        return this;
    }

    public Chapter get(int idx) {
        return chapters.get(idx);
    }

    public boolean isPresent(int idx) {
        return idx >= 0 && idx < chapters.size();
    }


    public static Saga create() {
        return new Saga();
    }

    public enum Result {
        FINISHED, ROLLBACK, CRASHED
    }

    public static class Chapter {
        String name;

        public Chapter(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
