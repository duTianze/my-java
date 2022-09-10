package com.dutianze.designpattern.game.eventqueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Slf4j
class AudioTest {

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            Audio audio = Audio.getInstance();
            audio.playSound(Audio.class.getResource("/sound/Bass-Drum-1.wav"), -10.0f);
            audio.playSound(Audio.class.getResource("/sound/Closed-Hi-Hat-1.wav"), -10.0f);

            assertTrue(audio.isServiceRunning());
            Thread.sleep(1000);
            audio.stopService();
            assertFalse(audio.isServiceRunning());
        });
    }
}