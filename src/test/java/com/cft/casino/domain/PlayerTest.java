package com.cft.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    @Test
    public void samplePassingTest() {
        Player player = new Player();

        assertEquals(0, player.getAvailableChips());
    }
}
