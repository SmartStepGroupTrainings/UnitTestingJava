package com.ssg.casino.domain;

public class DiceFake implements IDice {

    public int winningScore;

    public int roll() {
        return winningScore;
    }
}
