/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.dutianze.designpattern.others.specification.creature.impl;

import com.dutianze.designpattern.others.specification.property.Color;
import com.dutianze.designpattern.others.specification.property.Mass;
import com.dutianze.designpattern.others.specification.property.Movement;
import com.dutianze.designpattern.others.specification.property.Size;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class Shark extends AbstractCreature {

    public Shark() {
        this(new Mass(500.0));
    }

    public Shark(Mass mass) {
        super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, mass);
    }
}