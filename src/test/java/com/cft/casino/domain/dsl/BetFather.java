package com.cft.casino.domain.dsl;

import com.cft.casino.domain.Bet;

public class BetFather {
    private int amount;
    private int score;

    public BetFather(int amount) {
        this.amount = amount;
    }

    public BetFather on(int score) {
        this.score = score;
        return this;
    }

    public Bet please() {
        return new Bet(amount, score);
    }
}
