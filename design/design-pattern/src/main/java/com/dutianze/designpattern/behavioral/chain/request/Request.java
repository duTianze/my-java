package com.dutianze.designpattern.behavioral.chain.request;

import lombok.Getter;

import java.util.Objects;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class Request {

    @Getter
    private final RequestType requestType;

    @Getter
    private final String requestDescription;

    private boolean handled;

    public Request(final RequestType requestType, final String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    @Override
    public String toString() {
        return getRequestDescription();
    }

}
