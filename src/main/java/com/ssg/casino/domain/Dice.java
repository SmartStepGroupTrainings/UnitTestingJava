package com.ssg.casino.domain;

import java.util.Random;

/**
 * Created by ostkav15 22.05.18
 **/
public class Dice implements IDice {

    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
