package com.dutianze.designpattern.behavioral.observer;

import com.dutianze.designpattern.behavioral.observer.observer.WeatherObserver;
import com.dutianze.designpattern.behavioral.observer.types.WeatherType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Observer.html">java.util.Observer</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/EventListener.html">java.util.EventListener</a></li>
 * <li><a href="http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSessionBindingListener.html">javax.servlet.http.HttpSessionBindingListener</a></li>
 * <li><a href="https://github.com/ReactiveX/RxJava">RxJava</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class Weather {

    private WeatherType currentWeather;
    private final List<WeatherObserver> observers;

    public Weather() {
        observers = new ArrayList<>();
        currentWeather = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs) {
        observers.remove(obs);
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        log.info("The weather changed to {}.", currentWeather);
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver obs : observers) {
            obs.update(currentWeather);
        }
    }
}