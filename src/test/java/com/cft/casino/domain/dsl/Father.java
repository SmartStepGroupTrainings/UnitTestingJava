package com.cft.casino.domain.dsl;

import com.cft.casino.domain.CasinoGameException;
import com.cft.casino.domain.RollDiceGame;

import static org.mockito.Mockito.mock;

public class Father {
    public static final int UNLUCKY_SCORE = 1;
    public static final int LUCKY_SCORE = 6;

    public GameFather game() {
        return new GameFather();
    }

    public PlayerFather winnerIn(RollDiceGame game) throws CasinoGameException {
        PlayerFather playerFather = playerIn(game);
        playerFather.willBetOn(LUCKY_SCORE);
        return playerFather;
    }

    public PlayerFather looserIn(RollDiceGame game) throws CasinoGameException {
        PlayerFather playerFather = playerIn(game);
        playerFather.willBetOn(UNLUCKY_SCORE);
        return playerFather;
    }

    public PlayerFather playerIn(RollDiceGame game) throws CasinoGameException {
        PlayerFather playerFather = new PlayerFather();
        playerFather.in(game);
        return playerFather;
    }

    public DiceFather dice() {
        return new DiceFather(this);
    }

    public BetFather bet(int amount) {
        return new BetFather(amount);
    }
}
