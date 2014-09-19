package com.cft.casino.domain;

public class DiceStub implements IDice {
    private int score;

    @Override
    public int roll() {
        return score;
    }

    public void willAlwaysRoll(int score) {
        this.score = score;
    }
}
