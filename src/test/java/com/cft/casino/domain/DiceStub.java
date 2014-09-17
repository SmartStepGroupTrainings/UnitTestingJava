package com.cft.casino.domain;

public class DiceStub implements IDice {

    private int winningScore;

    @Override
    public int roll() {
        return winningScore;
    }

    public void willRoll(int winningScore) {
        this.winningScore = winningScore;
    }
}
