package com.dutianze.designpattern.game.eventqueue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

/**
 * @author dutianze
 * @date 2022/9/11
 */
@Getter
@AllArgsConstructor
public class AudioResource {

    private final URL resource;

    @Setter
    private float volume;
}
