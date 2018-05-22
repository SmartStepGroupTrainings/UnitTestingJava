package com.ssg.casino.domain;

import java.util.Random;

public class DiceImpl implements Dice {


    public int getDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
