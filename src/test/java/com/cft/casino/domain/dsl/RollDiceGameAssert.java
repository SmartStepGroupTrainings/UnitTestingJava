package com.cft.casino.domain.dsl;

import com.cft.casino.domain.RollDiceGame;

import static org.junit.Assert.assertEquals;

public class RollDiceGameAssert {
    private RollDiceGame game;
    private int expectedAmount;

    public RollDiceGameAssert(RollDiceGame game) {
        this.game = game;
    }

    public RollDiceGameAssert has(int amount) {
        this.expectedAmount = amount;
        return this;
    }

    public RollDiceGameAssert chips() {
        assertEquals(expectedAmount, game.getBankAmount());
        return this;
    }
}
