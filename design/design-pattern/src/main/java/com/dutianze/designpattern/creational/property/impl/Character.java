package com.dutianze.designpattern.creational.property.impl;

import com.dutianze.designpattern.creational.property.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/31
 */
public class Character implements Prototype {

    private String name;
    private Type type;
    private final Prototype prototype;
    private final Map<Stats, Integer> properties = new HashMap<>();

    public Character() {
        this.prototype = new Prototype() {
        };
    }

    public Character(Type type, Prototype prototype) {
        this.type = type;
        this.prototype = prototype;
    }

    public Character(String name, Character prototype) {
        this.name = name;
        this.type = prototype.type;
        this.prototype = prototype;
    }

    public String name() {
        return name;
    }

    public Type type() {
        return type;
    }

    @Override
    public Integer get(Stats stat) {
        boolean containsValue = properties.containsKey(stat);
        if (containsValue) {
            return properties.get(stat);
        }
        return prototype.get(stat);
    }

    @Override
    public boolean has(Stats stat) {
        return get(stat) != null;
    }

    @Override
    public void set(Stats stat, Integer val) {
        properties.put(stat, val);
    }

    @Override
    public void remove(Stats stat) {
        properties.put(stat, null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (name != null) {
            builder.append("Player: ").append(name).append('\n');
        }

        if (type != null) {
            builder.append("Character type: ").append(type.name()).append('\n');
        }

        builder.append("Stats:\n");
        for (Stats stat : Stats.values()) {
            Integer value = this.get(stat);
            if (value == null) {
                continue;
            }
            builder.append(" - ").append(stat.name()).append(':').append(value).append('\n');
        }
        return builder.toString();
    }
}
