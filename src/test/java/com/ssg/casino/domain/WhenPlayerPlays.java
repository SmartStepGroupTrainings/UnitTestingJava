package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenPlayerPlays extends BaseTest {

    @Test
    public void increaseInSixTimesAmountChips() throws CasinoGameException {
        RollDiceGame game = newGameForWin();
        Player winner = activePlayer(game, 100);
        winner.bet(doBet(10));

        game.play();

        assertEquals(100 - 10 + 10 * 6, winner.getAvailableChips());
    }
    
    @Test
    public void notChangeAmountChipsAfterFailGame() throws CasinoGameException {
        RollDiceGame game = newGameForLose();
        Player looser = activePlayer(game, 100);
        looser.bet(doBet(10));

        game.play();

        assertEquals(100 - 10, looser.getAvailableChips());
    }
}
