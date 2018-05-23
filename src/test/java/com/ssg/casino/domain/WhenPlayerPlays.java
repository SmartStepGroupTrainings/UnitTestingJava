package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import  static org.mockito.Mockito.*;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerPlays extends BaseTest {


    private ObjectFather create = new ObjectFather();

    @Test
    public void heWinTheGameWithTenChipsBetAndGetSixBets() throws CasinoGameException {
        RollDiceGame winGame = newRollDiceGameWithKnownScore();
        Player winner = playerWinGame(winGame);

        winGame.play();

        assertEquals(10 * 6, winner.getAvailableChips());
    }

    @Test
    public void heWinTheGameWithTenChipsBetAndGetSixBetsDSL() throws CasinoGameException {


        RollDiceGame winGame = create.game()
                .withDice(new Dice())
                .please();

        Player winner = create.activePlayer(winGame)
                .withChips(10)
                .withBet(10)
                .onScore(1)
                .please();


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
