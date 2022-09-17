package com.dutianze.designpattern.others.databus.memeber;

import com.dutianze.designpattern.others.databus.data.DataType;
import java.util.function.Consumer;

/**
 * @author dutianze
 * @date 2022/9/17
 */
public interface Member extends Consumer<DataType> {

  void accept(DataType event);
}
