package com.ssg.casino.domain;

public class Bet {
    private int score;
    public int amount;

    Bet () {

    }

    Bet(int amount) {
        this.amount = amount;
    }

    public Bet(int amount, int score) {
        this.amount = amount;
        this.score = score;

    }
}
