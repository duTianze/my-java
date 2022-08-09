package com.dutianze.designpattern.stepbuilder;

import lombok.Data;

import java.util.List;

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
