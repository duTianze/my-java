package com.dutianze.designpattern.creational.stepbuilder;

import java.util.List;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@Data
public class Character {

  private String name;
  private String fighterClass;
  private String wizardClass;
  private String weapon;
  private String spell;
  private List<String> abilities;

  public Character(String name) {
    this.name = name;
  }
}
