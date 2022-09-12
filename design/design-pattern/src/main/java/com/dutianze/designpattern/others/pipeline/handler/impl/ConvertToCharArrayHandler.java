package com.dutianze.designpattern.others.pipeline.handler.impl;

import com.dutianze.designpattern.others.pipeline.handler.Handler;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/4
 */
@Slf4j
public class ConvertToCharArrayHandler implements Handler<String, char[]> {

  @Override
  public char[] process(String input) {
    char[] characters = input.toCharArray();
    String string = Arrays.toString(characters);
    log.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        ConvertToCharArrayHandler.class, input, String.class, string, Character[].class);
    return characters;
  }
}
