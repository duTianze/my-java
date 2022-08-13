package com.dutianze.designpattern.behavioral.command.target;

import com.dutianze.designpattern.behavioral.command.target.valueobject.Size;
import com.dutianze.designpattern.behavioral.command.target.valueobject.Visibility;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class Goblin extends Target {

    public Goblin() {
        setSize(Size.NORMAL);
        setVisibility(Visibility.VISIBLE);
    }

    @Override
    public String toString() {
        return "Goblin";
    }
}