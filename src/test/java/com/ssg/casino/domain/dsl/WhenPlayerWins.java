package com.ssg.casino.domain.dsl;

import com.ssg.casino.domain.*;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WhenPlayerWins {

    ObjectFather create = new ObjectFather();

    @Test
    public void winnerGetsSixBets() throws CasinoGameException {

//        create active player in game with 10 chips
//        with bet 10 chips on score 1

        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(1);

        Player winner = create.activePlayer()
                .inGame(create.newGame().withDice(dice).please())
                .withChips(10)
                .withBet(10)
                .onScore(1)
                .please();

        winner.activeGame().play();

        assertEquals(10 * 6, winner.getAvailableChips());
    }


    @Test
    public void looserLooseAllChips() throws CasinoGameException {

//        create active player in game with 10 chips
//        with bet 10 chips on score 6 (but winner score is 1)

        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(1);
        RollDiceGame diceGame = create.newGame()
                .withDice(dice)
                .please();

        Player looser = create.activePlayer()
                .inGame(diceGame)
                .withChips(10)
                .withBet(10)
                .onScore(6)
                .please();


        looser.activeGame().play();


        assertEquals(0, looser.getAvailableChips());
    }


    @Test
    public void callPlayerWinForAllWinners() throws CasinoGameException {

//        create active player in game with 10 chips
//        with bet 10 chips on score 1

        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(1);
        RollDiceGame diceGame = create.newGame()
                .withDice(dice)
                .please();

        Player firstWinner = create.activePlayer()
                .inGame(diceGame)
                .withChips(10)
                .withBet(10)
                .onScore(1)
                .please();

        Player secondWinner = create.activePlayer()
                .inGame(diceGame)
                .withChips(10)
                .withBet(10)
                .onScore(1)
                .please();


        diceGame.play();


        verify(firstWinner, times(1)).win(anyInt());
        verify(secondWinner, times(1)).win(anyInt());
    }


}