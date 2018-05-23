package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import  static org.mockito.Mockito.*;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerPlays extends BaseTest {


    @Test
    public void heWinTheGameWithTenChipsBetAndGetSixBets() throws CasinoGameException {
        RollDiceGame winGame = newRollDiceGameWithKnownScore();
        Player winner = playerWinGame(winGame);

        winGame.play();

        assertEquals(10 * 6, winner.getAvailableChips());
    }

    @Test
    public void heLoseTheGameWithTenChipsBetAndLoseAllChips() throws CasinoGameException {
        RollDiceGame loseGame = newRollDiceGameWithKnownScore();
        Player looser = playerLoseGame(loseGame);

        loseGame.play();

        assertEquals(0, looser.getAvailableChips());
    }
}
