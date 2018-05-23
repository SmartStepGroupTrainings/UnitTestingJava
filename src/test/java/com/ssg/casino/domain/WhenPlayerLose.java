package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenPlayerLose {

    @Test
    public void loserLoseTheBet() throws CasinoGameException {
        Player loser = loserWhoBetAllChips();

        loser.activeGame().play();

        assertEquals(0, loser.getAvailableChips());
    }

    private Player newPlayer() {
        return new Player();
    }

    private Player loserWhoBetAllChips() throws CasinoGameException {
        int allChips = 10;
        Player player = newPlayer();
        player.buy(allChips);

        int winningScore = 1;
        RollDiceGame alwaysWinningGame = newGame(winningScore+1);
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