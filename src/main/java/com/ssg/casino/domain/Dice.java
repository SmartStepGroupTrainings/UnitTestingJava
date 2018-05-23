package com.ssg.casino.domain;

import java.util.Random;

public class Dice implements IDice {


    public int roll() {
        Random random = new Random();
        int winningScore = random.nextInt(6) + 1;

        return winningScore;
    }
}
