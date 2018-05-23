package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WhenPlayerPlays extends BaseTest {

    Создатель создатель = new Создатель();

    @Test
    public void callWinForAllWinersOnce() throws CasinoGameException {

        RollDiceGame alwaysWinerGame = newGameForWin();

        Player winner1 = spy(Player.class);
        winner1.joins(alwaysWinerGame);
        winner1.buy(100);
        winner1.bet(doBet(10));

        Player winner2 = spy(Player.class);
        winner2.joins(alwaysWinerGame);
        winner2.buy(100);
        winner2.bet(doBet(10));

        alwaysWinerGame.play();

        verify(winner1, times(1)).win(anyInt());
        verify(winner2, times(1)).win(anyInt());
    }

    @Test
    public void callLoseForAllLoosers() throws CasinoGameException {
        RollDiceGame game = newGameForLose();

        Player looser = spy(Player.class);
        looser.joins(game);
        looser.buy(100);

        looser.bet(doBet(10));

        game.play();

        verify(looser, times(1)).lose();
    }


    @Test
    public void increaseInSixTimesAmountChips() throws CasinoGameException {
        RollDiceGame играВсегдаСПобедой = newGameForWin();
        Player winner = создатель
                .дайРодителяИгрока()
                    .вИгре(играВсегдаСПобедой)
                    .сФишками(100)
                    .делаетСтавку(10)
                    .родить();

        играВсегдаСПобедой.play();

        assertEquals(100 - 10 + 10 * 6, winner.getAvailableChips());
    }
    
    @Test
    public void notChangeAmountChipsAfterFailGame() throws CasinoGameException {
        RollDiceGame alwaysLoosingGame = newGameForLose();
        Player looser = activeReachPlayer(alwaysLoosingGame);
        int oldChips = looser.getAvailableChips();
        looser.bet(doBet(10));

        alwaysLoosingGame.play();

        assertEquals(oldChips - 10, looser.getAvailableChips());
    }
}
