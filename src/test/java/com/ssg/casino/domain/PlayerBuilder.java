package com.ssg.casino.domain;

/**
 * Created by ostkav15 23.05.18
 **/
public class PlayerBuilder {
    private RollDiceGame game;
    private int chipsAmount;
    private int betAmount;
    private int betScore;

    public PlayerBuilder(RollDiceGame game) {
        this.game = game;
    }

    public PlayerBuilder withChips(int chipsAmount) {
        this.chipsAmount = chipsAmount;
        return this;
    }

    public PlayerBuilder withBet(int betAmount) {
        this.betAmount = betAmount;
        return this;
    }

    public PlayerBuilder onScore(int betScore) {
        this.betScore = betScore;
        return this;
    }

    public Player please() throws CasinoGameException {
        Player player = new Player();
        player.buy(chipsAmount);
        player.joins(game);
        player.bet(new Bet(betAmount, betScore));
        return player;
    }
}
