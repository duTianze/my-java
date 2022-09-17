package com.dutianze.designpattern.others.databus.data.impl;

import com.dutianze.designpattern.others.databus.data.AbstractDataType;
import com.dutianze.designpattern.others.databus.data.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Getter
@AllArgsConstructor
public class MessageData extends AbstractDataType {

  private final String message;

  public static DataType of(final String message) {
    return new MessageData(message);
  }
}
