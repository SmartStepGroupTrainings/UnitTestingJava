package com.cft.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameTests {

    @Test
    public void run_loser_losesHisBet() throws Exception {
        RollDiceGame game = new RollDiceGame();
        Player looser = new Player();
        looser.joins(game);
        looser.buyChips(100);
        looser.bet(new Bet(25, 1));
        IDice diceStub = mock(IDice.class);
        when(diceStub.roll()).thenReturn(6);

        game.play(diceStub);

        assertEquals(100 - 25, looser.getAvailableChips());
    }

    @Test
    public void run_winner_winsHisBet() throws Exception {
        int WINNING_SCORE = 1;
        RollDiceGame game = new RollDiceGame();
        Player winner = new Player();
        Player winnerSpy = spy(winner);
        winnerSpy.joins(game);
        int BET_AMOUNT = 100;
        winnerSpy.buyChips(1000);
        winnerSpy.bet(new Bet(BET_AMOUNT, WINNING_SCORE));
        IDice diceStub = mock(IDice.class);
        when(diceStub.roll()).thenReturn(WINNING_SCORE);

        game.play(diceStub);

        verify(winnerSpy, never()).lose();
        verify(winnerSpy, times(1)).win(6 * BET_AMOUNT);
    }


    @Test
    public void run_winner_winsHisBetWithWinningFactor() throws Exception {
        int WINNING_SCORE = 1;
        int WINNING_FACTOR = 10;
        RollDiceGameWithWinningFactorServiceStub game = new RollDiceGameWithWinningFactorServiceStub();
        game.WINNING_FACTOR = WINNING_FACTOR;
        Player winner = new Player();
        winner.joins(game);
        int BET_AMOUNT = 100;
        winner.buyChips(1000);
        winner.bet(new Bet(BET_AMOUNT, WINNING_SCORE));
        IDice diceStub = mock(IDice.class);
        when(diceStub.roll()).thenReturn(WINNING_SCORE);

        game.play(diceStub);

        assertEquals(1000 - BET_AMOUNT + BET_AMOUNT * WINNING_FACTOR, winner.getAvailableChips());
    }
}

