package com.dutianze.designpattern.others.sharding.model;

/**
 * @author dutianze
 * @date 2022/8/25
 */
@lombok.Data
public class Data {

  private int key;

  private String value;

  private DataType type;

  public Data(final int key, final String value, final DataType type) {
    this.key = key;
    this.value = value;
    this.type = type;
  }

  public enum DataType {
    TYPE_1, TYPE_2, TYPE_3
  }
}
