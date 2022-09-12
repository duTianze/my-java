package com.dutianze.designpattern.others.pipeline.handler.impl;

import com.dutianze.designpattern.others.pipeline.handler.Handler;
import java.util.function.IntPredicate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/4
 */
@Slf4j
public class RemoveAlphabetsHandler implements Handler<String, String> {

  @Override
  public String process(String input) {
    StringBuilder inputWithoutAlphabets = new StringBuilder();
    IntPredicate isAlphabetic = Character::isAlphabetic;
    input.chars()
        .filter(isAlphabetic.negate())
        .mapToObj(x -> (char) x)
        .forEachOrdered(inputWithoutAlphabets::append);
    String inputWithoutAlphabetsStr = inputWithoutAlphabets.toString();
    log.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        RemoveAlphabetsHandler.class, input, String.class, inputWithoutAlphabetsStr, String.class);
    return inputWithoutAlphabetsStr;
  }
}
