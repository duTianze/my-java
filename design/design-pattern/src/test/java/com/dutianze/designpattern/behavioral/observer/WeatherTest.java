package com.dutianze.designpattern.behavioral.observer;

import com.dutianze.designpattern.behavioral.observer.observer.WeatherObserver;
import com.dutianze.designpattern.behavioral.observer.observer.impl.Hobbits;
import com.dutianze.designpattern.behavioral.observer.observer.impl.Orcs;
import com.dutianze.designpattern.behavioral.observer.types.WeatherType;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class WeatherTest {

    @Test
    void testTimePasses() {
        final WeatherObserver observer = mock(WeatherObserver.class);
        final Weather weather = new Weather();
        weather.addObserver(observer);

        final InOrder inOrder = inOrder(observer);
        final WeatherType[] weatherTypes = WeatherType.values();
        for (int i = 1; i < 20; i++) {
            weather.timePasses();
            inOrder.verify(observer).update(weatherTypes[i % weatherTypes.length]);
        }

        verifyNoMoreInteractions(observer);
    }

    @Test
    void testObserver() {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
    }
}