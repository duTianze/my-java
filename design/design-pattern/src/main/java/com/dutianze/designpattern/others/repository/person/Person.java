package com.dutianze.designpattern.others.repository.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Data
@Entity
@NoArgsConstructor
public class Person {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String surname;
  private int age;

  public Person(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }
}
