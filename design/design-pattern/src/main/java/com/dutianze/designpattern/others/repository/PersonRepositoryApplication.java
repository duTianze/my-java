package com.dutianze.designpattern.others.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h2 id="real-world-examples">Real world examples</h2>
 * <ul>
 * <li><p><a href="http://projects.spring.io/spring-data/">Spring Data</a></p>
 * </li>
 * <li><p><a href="https://github.com/spring-projects/spring-data-examples">Spring Data repo</a></p>
 * </li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/28
 */
@SpringBootApplication
public class PersonRepositoryApplication {

  public static void main(String[] args) {
    SpringApplication.run(PersonRepositoryApplication.class, args);
  }

}
