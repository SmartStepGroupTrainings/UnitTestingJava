package com.cft.casino.domain;

import java.util.Random;

public class Dice implements IDice {
    @Override
    public int roll() {
        Random random = new Random();
        return 1 + random.nextInt(6);
    }
}
