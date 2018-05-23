package com.ssg.casino.domain.dsl;

import com.ssg.casino.domain.IDice;
import com.ssg.casino.domain.RollDiceGame;

public class GameBuilder {

    private IDice dice;


    private RollDiceGame newGame(IDice dice) {
        return new RollDiceGame(dice);
    }

    public RollDiceGame please() {
        return newGame(dice);
    }

    public GameBuilder withDice(IDice dice) {
        this.dice = dice;
        return this;
    }
}
