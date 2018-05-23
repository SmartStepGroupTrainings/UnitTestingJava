package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import  static org.mockito.Mockito.*;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerPlays extends BaseTest {

    private RollDiceGame newRollDiceGameWithKnownScore() {
        Dice dice = mock(Dice.class);
        when(dice.roll()).thenReturn(1);

        return new RollDiceGame(dice);
    }

    private Player newPlayerWithChipsJoinsGameAndBetForScore(int chipsAmount, int betScore, RollDiceGame game) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.buy(chipsAmount);
        newPlayer.joins(game);
        newPlayer.bet(new Bet(chipsAmount, betScore));
        return newPlayer;
    }

    private Player playerWinGame(RollDiceGame game) throws CasinoGameException {
        return newPlayerWithChipsJoinsGameAndBetForScore(10, 1, game);
    }

    private Player playerLoseGame(RollDiceGame game) throws CasinoGameException {
        return newPlayerWithChipsJoinsGameAndBetForScore(10, 1 + 1, game);
    }

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
