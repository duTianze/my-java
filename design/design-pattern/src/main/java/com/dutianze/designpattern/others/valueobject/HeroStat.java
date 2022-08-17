package com.dutianze.designpattern.others.valueobject;

import lombok.Value;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html">java.util.Optional</a></li>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html">java.time.LocalDate</a></li>
 * <li><a href="http://www.joda.org/">joda-time, money, beans</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/17
 */
@Value(staticConstructor = "valueOf")
public class HeroStat {

    int strength;
    int intelligence;
    int luck;
}
