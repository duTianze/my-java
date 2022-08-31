package com.dutianze.designpattern.behavioral.observer.observer.impl;

import com.dutianze.designpattern.behavioral.observer.observer.WeatherObserver;
import com.dutianze.designpattern.behavioral.observer.types.WeatherType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class Orcs implements WeatherObserver {

    @Override
    public void update(WeatherType currentWeather) {
        log.info("The orcs are facing " + currentWeather.getDescription() + " weather now");
    }
}