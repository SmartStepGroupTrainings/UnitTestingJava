package com.cft.casino.domain;

import java.util.Random;

public class Dice implements IDice {
    private static Random random = new Random();

    @Override
    public int roll() {
        return 1 + random.nextInt(6);
    }
}
