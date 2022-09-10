package com.dutianze.designpattern.creational.factory.coin;

import com.dutianze.designpattern.creational.factory.coin.impl.CopperCoin;
import com.dutianze.designpattern.creational.factory.coin.impl.GoldCoin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

/**
 * @author dutianze
 * @date 2022/9/8
 */
@RequiredArgsConstructor
@Getter
public enum CoinType {

    COPPER(CopperCoin::new),
    GOLD(GoldCoin::new);

    private final Supplier<Coin> constructor;
}
