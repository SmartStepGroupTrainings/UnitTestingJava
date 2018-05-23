package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenPlayerPlays extends BaseTest {

    @Test
    public void increaseInSixTimesAmountChips() throws CasinoGameException {
        RollDiceGame alwaysWinnerGame = newGameForWin();
        Player winner = activeReachPlayer(alwaysWinnerGame);
        winner.bet(doBet(10));
        int oldChips = winner.getAvailableChips();

        alwaysWinnerGame.play();

        assertEquals(oldChips - 10 + 10 * 6, winner.getAvailableChips());
    }
    
    @Test
    public void notChangeAmountChipsAfterFailGame() throws CasinoGameException {
        RollDiceGame alwaysLoosingGame = newGameForLose();
        Player looser = activeReachPlayer(alwaysLoosingGame);
        looser.bet(doBet(10));
        int oldChips = looser.getAvailableChips();

        alwaysLoosingGame.play();

        assertEquals(oldChips - 10, looser.getAvailableChips());
    }
}
