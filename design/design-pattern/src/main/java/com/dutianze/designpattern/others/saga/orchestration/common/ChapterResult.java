package com.dutianze.designpattern.others.saga.orchestration.common;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class ChapterResult<K> {

    private final K value;
    private final State state;

    public K getValue() {
        return value;
    }

    ChapterResult(K value, State state) {
        this.value = value;
        this.state = state;
    }

    public boolean isSuccess() {
        return state == State.SUCCESS;
    }

    public static <K> ChapterResult<K> success(K val) {
        return new ChapterResult<>(val, State.SUCCESS);
    }

    public static <K> ChapterResult<K> failure(K val) {
        return new ChapterResult<>(val, State.FAILURE);
    }

    public enum State {
        SUCCESS, FAILURE
    }
}
