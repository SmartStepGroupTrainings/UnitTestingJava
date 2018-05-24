package com.ssg.casino.domain;

public class PlayerBuilder {


    private Bet bet;
    private Game game;
    private int chips;

    public PlayerBuilder withBet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public PlayerBuilder withGame(Game game) {
        this.game = game;
        return this;
    }

    public Player please() {
        Player player = new Player();

        player.bet = this.bet;
        return player;
    }

    public PlayerBuilder withChips(int chips) {
        this.chips = chips;
        return this;
    }
}
