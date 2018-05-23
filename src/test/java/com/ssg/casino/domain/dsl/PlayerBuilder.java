package com.ssg.casino.domain.dsl;

import com.ssg.casino.domain.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerBuilder {
    private RollDiceGame rollDiceGame;
    private int chips;
    private int bet;
    private int score;

    public PlayerBuilder inGame(RollDiceGame rollDiceGame){
        this.rollDiceGame = rollDiceGame;
        return this;
    }

    public PlayerBuilder withChips(int chips) {
        this.chips = chips;
        return this;
    }

    public PlayerBuilder withBet(int bet) {
        this.bet = bet;
        return this;
    }

    public PlayerBuilder onScore(int score) {
        this.score = score;
        return this;
    }

    public Player please() throws CasinoGameException {
        Player player = new Player();
        player.buy(chips);
        player.joins(rollDiceGame);
        player.bet(new Bet(bet,score));

        return player;
    }


}
