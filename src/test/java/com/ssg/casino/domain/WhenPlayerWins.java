package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenPlayerWins extends BaseTest {

    @Test
    public void increaseSixAmountChips() throws CasinoGameException {
        RollDiceGame game = newRollDiceGameWithFakeWin(6);
        Player newPlayer = activePlayer(game, 10);
        newPlayer.bet(new Bet(10, 6));

        game.play();

        assertEquals(10 * 6, newPlayer.getAvailableChips());
    }
}
