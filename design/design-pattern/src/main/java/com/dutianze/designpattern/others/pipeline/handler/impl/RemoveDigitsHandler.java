package com.dutianze.designpattern.others.pipeline.handler.impl;

import com.dutianze.designpattern.others.pipeline.handler.Handler;
import java.util.function.IntPredicate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dutianze
 * @date 2022/9/4
 */
@Slf4j
public class RemoveDigitsHandler implements Handler<String, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDigitsHandler.class);

  @Override
  public String process(String input) {
    StringBuilder inputWithoutDigits = new StringBuilder();
    IntPredicate isDigit = Character::isDigit;
    input.chars()
        .filter(isDigit.negate())
        .mapToObj(x -> (char) x)
        .forEachOrdered(inputWithoutDigits::append);

    var inputWithoutDigitsStr = inputWithoutDigits.toString();
    LOGGER.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        RemoveDigitsHandler.class, input, String.class, inputWithoutDigitsStr, String.class);
    return inputWithoutDigitsStr;
  }
}
