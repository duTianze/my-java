package com.dutianze.designpattern.others.databus.data;

import com.dutianze.designpattern.others.databus.DataBus;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Getter
@Setter
public class AbstractDataType implements DataType {

  private DataBus dataBus;
}
