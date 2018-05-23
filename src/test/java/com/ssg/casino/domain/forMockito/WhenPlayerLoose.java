package com.ssg.casino.domain.forMockito;

import com.ssg.casino.domain.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenPlayerLoose {

    @Test
    public void loserLooseTheBet() throws CasinoGameException {
        Player looser = looserWhoBetAllChips();

        looser.activeGame().play();

        assertEquals(0, looser.getAvailableChips());
    }

    private Player newPlayer() {
        return new Player();
    }

    private Player looserWhoBetAllChips() throws CasinoGameException {
        int allChips = 10;
        Player player = newPlayer();
        player.buy(allChips);

        int winningScore = 1;
        RollDiceGame alwaysLosingGame = newGame(winningScore + 1);
        player.joins(alwaysLosingGame);

        Bet bet = new Bet(allChips, winningScore);
        player.bet(bet);

        return player;
    }

    private RollDiceGame newGame(int winningScore) {
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(winningScore);
        RollDiceGame diceGame = new RollDiceGame(dice);

        return diceGame;
    }


}