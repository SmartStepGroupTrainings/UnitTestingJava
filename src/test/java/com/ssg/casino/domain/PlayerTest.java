package com.ssg.casino.domain;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void PlayerShouldBuyChips() throws CasinoGameException {
        Player player = new Player();
        player.buy(1);
        Assert.assertEquals(1, player.getAvailableChips());
    }

    @Test
    public void PlayerShouldJoinIntoGame() throws CasinoGameException {
        Player player = new Player();
        player.joins(new RollDiceGame());
        Assert.assertNotNull(player.activeGame());
    }

    @Test(expected = NullPointerException.class)
    public void PlayerNotShouldLeaveGameIfHasNotStarted() throws CasinoGameException {
        Player player = new Player();
        player.leave();
        Assert.assertNull(player.activeGame());
    }
}