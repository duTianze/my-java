package com.dutianze.designpattern.others.eventdrivenarchitecture.event;

import com.dutianze.designpattern.others.eventdrivenarchitecture.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/9/12
 */
@Getter
@RequiredArgsConstructor
public class UserCreatedEvent extends AbstractEvent {

  private final User user;
}
