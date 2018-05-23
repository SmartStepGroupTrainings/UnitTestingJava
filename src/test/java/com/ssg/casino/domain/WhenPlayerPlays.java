package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import  static org.mockito.Mockito.*;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerPlays extends BaseTest {


    private ObjectFather create = new ObjectFather();
    private RollDiceGame winGame;
    private RollDiceGame loseGame;

    @Before
    public void init() {
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(3, 1, 2, 1);

        this.winGame = create.game()
                .withDice(dice)
                .please();

        this.loseGame = create.game()
                .withDice(dice)
                .please();
    }

    @Test
    public void heWinTheGameWithTenChipsBetAndGetSixBets() throws CasinoGameException {
        RollDiceGame winGame = newRollDiceGameWithKnownScore();
        Player winner = playerWinGame(winGame);

        winGame.play();

        assertEquals(10 * 6, winner.getAvailableChips());
    }

    @Test
    public void winnerGetsSixBets() throws CasinoGameException {

        Player winner = create.playerInGame(winGame)
                .withChips(12)
                .withAllChipsBet()
                .onWinningScore()
                .please();


        winGame.play();

        assertEquals( 12 * 6, winner.getAvailableChips());
    }

    @Test
    public void heLoseTheGameWithTenChipsBetAndLoseAllChips() throws CasinoGameException {
        Player looser = create.playerInGame(loseGame)
                .withChips(12)
                .withAllChipsBet()
                .onLoosingScore()
                .please();

        loseGame.play();

        assertEquals(0, looser.getAvailableChips());
    }
}
