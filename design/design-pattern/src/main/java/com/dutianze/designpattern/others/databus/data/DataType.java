package com.dutianze.designpattern.others.databus.data;

import com.dutianze.designpattern.others.databus.DataBus;

/**
 * @author dutianze
 * @date 2022/9/17
 */
public interface DataType {

  DataBus getDataBus();

  void setDataBus(DataBus dataBus);
}
