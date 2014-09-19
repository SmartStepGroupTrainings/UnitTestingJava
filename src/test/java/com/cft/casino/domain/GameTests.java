package com.cft.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTests {

    @Test
    public void run_loser_losesHisBet() throws Exception {
        RollDiceGame game = new RollDiceGame();
        Player looser = new Player();
        looser.joins(game);
        looser.buyChips(100);
        looser.bet(new Bet(25, 1));
        DiceStub dice = new DiceStub();
        dice.willAlwaysRoll(6);

        game.play(dice);

        assertEquals(100 - 25, looser.getAvailableChips());
    }

    @Test
    public void run_winner_winsHisBet() throws Exception {
        int WINNING_SCORE = 1;
        RollDiceGame game = new RollDiceGame();
        Player winner = new Player();
        winner.joins(game);
        int BET_AMOUNT = 100;
        winner.buyChips(1000);
        winner.bet(new Bet(BET_AMOUNT, WINNING_SCORE));
        DiceStub dice = new DiceStub();
        dice.willAlwaysRoll(WINNING_SCORE);

        game.play(dice);

        assertEquals(1000 - BET_AMOUNT + 6 * BET_AMOUNT, winner.getAvailableChips());
    }
}

