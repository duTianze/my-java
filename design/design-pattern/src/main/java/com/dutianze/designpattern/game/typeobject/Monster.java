package com.dutianze.designpattern.game.typeobject;

import lombok.Data;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://gameprogrammingpatterns.com/type-object.html">Game Programming Patterns - Type Object</a></li>
 * <li><a href="http://www.cs.sjsu.edu/~pearce/modules/patterns/analysis/top.htm">Types as Objects Pattern</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/20
 */
@Data
public class Monster {

    private int health;
    private String attack;
    private Breed breed;

    public Monster(Breed breed) {
        this.breed = breed;
        health = breed.getHealth();
        attack = breed.getAttack();
    }
}