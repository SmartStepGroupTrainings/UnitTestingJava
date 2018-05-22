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
    public void init_ForNewPlayer_ActiveGameIsNull() {
        assertNull(player.activeGame());
    }


    @Test
    public void init_ForNewPlayer_ChipsCountIsZero() {
        int expectedInitChipsCount = 0;
        assertEquals(expectedInitChipsCount, player.getAvailableChips());
    }

    @Test
    public void joins_PlayerHasGame_GameIsNotNull() throws CasinoGameException {
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
        player.buy(-10);
    }

    @Test(expected = CasinoGameException.class)
    public void joins_GameIsNull_ThrowsException() throws CasinoGameException {
        RollDiceGame game = new RollDiceGame();

        player.joins(game);
        player.joins(game);
    }

    @Test
    public void leave_IsInGame_GameIsNull() throws CasinoGameException {
        RollDiceGame game = new RollDiceGame();
        player.joins(game);
        player.leave();
    }

    @Ignore
    @Test(expected = CasinoGameException.class)
    public void leave_IsNotInGame_ThrowsException() throws CasinoGameException {
        RollDiceGame game = null;
        player.joins(game);
        player.leave();
    }
}