package com.dutianze.designpattern.creational.prototype.hero;

import com.dutianze.designpattern.creational.prototype.Prototype;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/9
 */
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Beast implements Prototype {

    public Beast(Beast source) {
    }

    @Override
    public abstract Beast copy();
}
