package com.cft.casino.domain.dsl;

import com.cft.casino.domain.Player;

import static org.junit.Assert.assertEquals;

public class PlayerAssert {
    private Player player;
    private int expectedValue;

    public PlayerAssert(Player player) {
        this.player = player;
    }

    public PlayerAssert has(int expectedValue) {
        this.expectedValue = expectedValue;
        return this;
    }

    public PlayerAssert chips() {
        assertEquals(expectedValue, player.getAvailableChips());
        return this;
    }
}
