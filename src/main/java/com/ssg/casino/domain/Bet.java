package com.ssg.casino.domain;

public class Bet {
    private int amount;
    private int score;

    public Bet(int amount, int score) {
        this.amount = amount;
        this.score = score;
    }

    public int getAmount() {
        return amount;
    }

    public int getScore() {
        return score;
    }
}