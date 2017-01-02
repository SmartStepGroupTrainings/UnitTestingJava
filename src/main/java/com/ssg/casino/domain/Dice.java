package com.ssg.casino.domain;

import java.util.Random;

public class Dice implements IDice {
    private static Random random = new Random();

    public int roll() {
        return 1 + random.nextInt(6);
    }
}
