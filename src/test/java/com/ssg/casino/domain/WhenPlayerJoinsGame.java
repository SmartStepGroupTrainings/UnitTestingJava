package com.ssg.casino.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WhenPlayerJoinsGame {


    private Player newActivePlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newGame());
        return player;
    }


    private Player newPlayer() {
        return new Player();
    }

    private RollDiceGame newGame() {
        return new RollDiceGame();
    }


    @Test
    public void activeGameIsNotNull() throws CasinoGameException {
        Player player = newPlayer();

        player.joins(newGame());

        assertNotNull(player.activeGame());
    }


    @Test
    public void heCanBuyChips() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        activePlayer.buy(10);

        assertEquals(10,activePlayer.getAvailableChips());
    }


    @Test(expected = CasinoGameException.class)
    public void heCannotBuyNegativeChips() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        activePlayer.buy(-1);
    }


    @Test(expected = CasinoGameException.class)
    public void heCannotJoinTwoGamesAtTheSameTime() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        RollDiceGame anotherGame = newGame();

        activePlayer.joins(anotherGame);
    }


    @Test
    public void heCanLeaveGame() throws CasinoGameException {
        Player activePlayer = newActivePlayer();

        activePlayer.leave();
    }


}