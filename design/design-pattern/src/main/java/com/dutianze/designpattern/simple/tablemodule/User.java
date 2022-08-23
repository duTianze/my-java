package com.dutianze.designpattern.simple.tablemodule;

import lombok.*;

/**
 * @author dutianze
 * @date 2022/8/23
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
}
