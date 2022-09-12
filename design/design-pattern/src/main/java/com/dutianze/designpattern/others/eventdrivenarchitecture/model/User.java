package com.dutianze.designpattern.others.eventdrivenarchitecture.model;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public record User(String username) {

  public String getUsername() {
    return username;
  }
}
