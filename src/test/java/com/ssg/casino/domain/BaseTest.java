package com.ssg.casino.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by ostkav15 22.05.18
 **/
public abstract class BaseTest {

    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected Player newActivePlayer() throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(newRollDiceGame());
        return newPlayer;
    }

    protected Bet newBetByAmount(int amount) {
        return new Bet(amount, 5);
    }

    protected RollDiceGame newRollDiceGameWithKnownScore() {
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(3, 1, 2, 1);

        return new RollDiceGame(dice);
    }

    private Player newPlayerWithChipsJoinsGameAndBetForScore(int chipsAmount, int betScore, RollDiceGame game) throws CasinoGameException {
        Player newPlayer = spy(newPlayer());
        newPlayer.buy(chipsAmount);
        newPlayer.joins(game);
        newPlayer.bet(new Bet(chipsAmount, betScore));
        return newPlayer;
    }

    protected Player playerWinGame(RollDiceGame game) throws CasinoGameException {
        return newPlayerWithChipsJoinsGameAndBetForScore(10, 1, game);
    }

    protected Player playerLoseGame(RollDiceGame game) throws CasinoGameException {
        return newPlayerWithChipsJoinsGameAndBetForScore(10, 1 + 1, game);
    }
}
