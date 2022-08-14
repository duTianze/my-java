package com.dutianze.designpattern.behavioral.observer.observer;

import com.dutianze.designpattern.behavioral.observer.types.WeatherType;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public interface WeatherObserver {

    void update(WeatherType currentWeather);
}