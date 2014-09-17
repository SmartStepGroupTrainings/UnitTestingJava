package com.cft.casino.domain.dsl;

import com.cft.casino.domain.Bet;
import com.cft.casino.domain.CasinoGameException;
import com.cft.casino.domain.Player;
import com.cft.casino.domain.RollDiceGame;

public class PlayerFather {
    private Player player = new Player();
    private int DEFAULT_BET = 1;
    private int amount;
    private int luckyScore = 0;

    public PlayerFather in(RollDiceGame game) throws CasinoGameException {
        player.joins(game);
        return this;
    }

    public PlayerFather withBet(int betAmount) throws CasinoGameException {
        player.bet(new Bet(betAmount, luckyScore != 0 ? luckyScore : DEFAULT_BET));
        return this;
    }

    public PlayerFather with(int amount) {
        this.amount = amount;
        return this;
    }

    public PlayerFather chips() throws CasinoGameException {
        player.buyChips(amount);
        return this;
    }

    public PlayerFather willBetOn(int luckyScore) {
        this.luckyScore = luckyScore;
        return this;
    }

    public Player please() {
        return player;
    }

    public PlayerFather with(Bet bet) throws CasinoGameException {
        player.bet(bet);
        return this;
    }
}
