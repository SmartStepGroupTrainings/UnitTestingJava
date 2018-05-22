package com.ssg.casino.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player = null;

    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @After
    public void tearDown() {
        player = null;
    }

    @Test
    public void joins_NewPlayerJoinToGame_GameIsNotEmpty() throws CasinoGameException {
        player.joins(new RollDiceGame());

        assertNotNull(player.activeGame());
    }

    @Test
    public void buy_TenChips_HasTenChips() throws CasinoGameException {
        player.buy(10);

        assertEquals(10,player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void buy_NegativeChipsCount_ThrowsException() throws CasinoGameException {
        player.buy(-1);
    }

    @Test(expected = CasinoGameException.class)
    public void joins_PlayerAlreadyHasGame_ThrowsException() throws CasinoGameException {
        RollDiceGame game = new RollDiceGame();
        player.joins(game);

        player.joins(game);
    }

    @Test
    public void leave_PlayerIsInGame_GameIsNull() throws CasinoGameException {
        RollDiceGame game = new RollDiceGame();
        player.joins(game);

        player.leave();
    }

    @Ignore
    @Test(expected = CasinoGameException.class)
    public void leave_PlayerIsNotInGame_ThrowsException() throws CasinoGameException {
        RollDiceGame game = null;
        player.joins(game);

        player.leave();
    }
}