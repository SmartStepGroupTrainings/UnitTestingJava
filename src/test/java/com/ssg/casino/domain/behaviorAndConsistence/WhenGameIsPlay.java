package com.ssg.casino.domain.behaviorAndConsistence;

import com.ssg.casino.domain.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

public class WhenGameIsPlay {

    @Test
    public void diceIsRolledOnce() throws CasinoGameException {
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(3).thenReturn(1).thenReturn(3).thenReturn(6);
        RollDiceGame diceGame = newDiceGame(dice);

        diceGame.play();

        verify(dice, times(4)).roll();
    }

    private RollDiceGame newDiceGame(IDice dice) {
        return new RollDiceGame(dice);
    }

    @Test
    public void callPlayerWinForAllWinners() throws CasinoGameException {
        RollDiceGame diceGame = getRollDiceGame();

        Player firstWinner = newWinnerPlayer(diceGame);
        Player secondWinner = newWinnerPlayer(diceGame);


        diceGame.play();


        verify(firstWinner, times(1)).win(anyInt());
        verify(secondWinner, times(1)).win(anyInt());

    }

    @Test
    public void noCallPlayerWinForAllLoosers() throws CasinoGameException {
        RollDiceGame diceGame = getRollDiceGame();

        Player firstLooser = newLooserPlayer(diceGame);
        Player secondLooser = newLooserPlayer(diceGame);


        diceGame.play();


        verify(firstLooser, times(0)).win(anyInt());
        verify(secondLooser, times(0)).win(anyInt());

    }

    private RollDiceGame getRollDiceGame() {
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(1);
        return new RollDiceGame(dice);
    }


    private Player newWinnerPlayer(RollDiceGame diceGame) throws CasinoGameException {
        Player winner = spy(Player.class);
        winner.buy(10);

        winner.joins(diceGame);

        winner.bet(new Bet(10,1));

        return winner;
    }

    private Player newLooserPlayer(RollDiceGame diceGame) throws CasinoGameException {
        Player winner = spy(Player.class);
        winner.buy(10);

        winner.joins(diceGame);

        winner.bet(new Bet(10,2));

        return winner;
    }

}