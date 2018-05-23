package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WhenPlayerWins {

    @Test
    public void winnerBetSixBets() throws CasinoGameException {
        Player winner = winnerWhoBetAllChips(10);

        winner.activeGame().play();

        assertEquals(10 * 6 - 10, winner.getAvailableChips());
    }

    private Player newPlayer() {
        return new Player();
    }

    private Player winnerWhoBetAllChips(int allChips) throws CasinoGameException {
        Player player = newPlayer();
        player.buy(allChips);

        int winningScore = 1;
        RollDiceGame alwaysWinningGame = newGame(winningScore);
        player.joins(alwaysWinningGame);

        Bet bet = new Bet(allChips, winningScore);
        player.bet(bet);

        return player;
    }

    private RollDiceGame newGame(int winningScore) {
        DiceFake dice = new DiceFake();
        dice.winningScore = winningScore;
        RollDiceGame diceGame = new RollDiceGame(dice);

        return diceGame;
    }


}