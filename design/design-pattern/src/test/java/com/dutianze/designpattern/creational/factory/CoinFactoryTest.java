package com.dutianze.designpattern.creational.factory;

import com.dutianze.designpattern.creational.factory.coin.Coin;
import com.dutianze.designpattern.creational.factory.coin.CoinType;
import com.dutianze.designpattern.creational.factory.coin.impl.CopperCoin;
import com.dutianze.designpattern.creational.factory.coin.impl.GoldCoin;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/9/8
 */
@Slf4j
class CoinFactoryTest {

    @Test
    void usage() {
        log.info("The alchemist begins his work.");
        Coin copperCoin = CoinFactory.getCoin(CoinType.COPPER);
        assertTrue(copperCoin instanceof CopperCoin);
        log.info(copperCoin.getDescription());

        Coin goldCoin = CoinFactory.getCoin(CoinType.GOLD);
        assertTrue(goldCoin instanceof GoldCoin);
        log.info(goldCoin.getDescription());
    }
}