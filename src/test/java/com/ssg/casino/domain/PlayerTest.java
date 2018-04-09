package com.ssg.casino.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void PlayerShouldBuyChips() throws CasinoGameException {
        Player player = new Player();
        player.buy(1);
        Assert.assertEquals(1, player.getAvailableChips());
    }

    @Test
    public void PlayerShouldJoinToGame() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        Assert.assertNotNull(player.activeGame());
    }

    @Test(expected = NullPointerException.class)
    public void PlayerShouldLeaveFromGame() throws CasinoGameException {
        Player player = new Player();
        player.leave();
        Assert.assertNull(player.activeGame());
    }
}