package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerWins extends BaseTest {

    private RollDiceGame newRollDiceGameWithKnownScore(final int winsScore) {
        return new RollDiceGame(new IDice() {
            public int roll() {
                return winsScore;
            }
        });
    }

    private Player newPlayerWithChipsJoinsGame(int initialAmountChips, RollDiceGame game) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.buy(initialAmountChips);
        newPlayer.joins(game);
        return newPlayer;
    }

    @Test
    public void heGetsBetsAmount() throws CasinoGameException {
        RollDiceGame game = newRollDiceGameWithKnownScore(1);
        Player newPlayer = newPlayerWithChipsJoinsGame(10, game);
        newPlayer.bet( new Bet(10,1));

        game.play();

        assertEquals((10-10)+10*6,newPlayer.getAvailableChips());
    }
}
