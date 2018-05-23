package com.ssg.casino.domain.forMockito;

import com.ssg.casino.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenPlayerWins {

    @Test
    public void winnerBetSixBets() throws CasinoGameException {
        Player winner = winnerWhoBetAllChips(10);

        winner.activeGame().play();

        assertEquals(10 * 6, winner.getAvailableChips());
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
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(winningScore);
        RollDiceGame diceGame = new RollDiceGame(dice);

        return diceGame;
    }


}