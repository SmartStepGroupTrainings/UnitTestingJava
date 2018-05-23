package com.ssg.casino.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {
    private static int WIN_SCORE = 1;
    private static int LOSE_SCORE = 2;

    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected RollDiceGame newGameForWin() {
        Dice dice = mock(Dice.class);
        when(dice.getDice()).thenReturn(WIN_SCORE);
        return new RollDiceGame(dice);
    }

    protected RollDiceGame newGameForLose() {
        Dice dice = mock(Dice.class);
        when(dice.getDice()).thenReturn(LOSE_SCORE);
        return new RollDiceGame(dice);
    }

    protected Player activeReachPlayer(RollDiceGame game) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(game);
        newPlayer.buy(100000);
        return newPlayer;
    }

    protected Bet doBet(int amountChips) {
        return new Bet(amountChips, WIN_SCORE);
    }

    protected Player activeReachPlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newRollDiceGame());

        return player;
    }
}
