package com.dutianze.designpattern.others.databus.data.impl;

import com.dutianze.designpattern.others.databus.data.AbstractDataType;
import com.dutianze.designpattern.others.databus.data.DataType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@RequiredArgsConstructor
@Getter
public class StoppingData extends AbstractDataType {

  private final LocalDateTime when;

  public static DataType of(final LocalDateTime when) {
    return new StoppingData(when);
  }
}

