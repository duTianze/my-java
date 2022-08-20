package com.dutianze.designpattern.game.typeobject;

import com.dutianze.designpattern.game.typeobject.resource.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Data
public class Breed {

    private String name;
    private int health;
    private String attack;

    @JsonAdapter(JsonParser.ParentAdapterFactory.class)
    private Breed parent;

    public Breed(Breed parent, String name, int health, String attack) {
        this.parent = parent;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public Monster newMonster() {
        return new Monster(this);
    }
}