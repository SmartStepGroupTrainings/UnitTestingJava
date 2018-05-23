package com.ssg.casino.domain;

/**
 * Created by ostkav15 23.05.18
 **/
public class GameBuilder {
    private Dice dice;

    public GameBuilder withDice(Dice dice) {
        this.dice = dice;
        return this;
    }


    public RollDiceGame please() {
        return new RollDiceGame(dice);
    }
}
