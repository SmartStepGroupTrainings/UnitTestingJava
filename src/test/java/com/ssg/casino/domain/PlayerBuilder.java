package com.ssg.casino.domain;

public class PlayerBuilder {


    private Bet bet;

    public PlayerBuilder withBet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public Player please() {
        Player player = new Player();

        player.bet = this.bet;

    }
}
