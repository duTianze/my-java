package com.dutianze.designpattern.game.objectpool.oliphaunt;

import com.dutianze.designpattern.game.objectpool.ObjectPool;

/**
 * @author dutianze
 * @date 2022/9/4
 */
public class OliphauntPool extends ObjectPool<Oliphaunt> {

    @Override
    protected Oliphaunt create() {
        return new Oliphaunt();
    }
}
