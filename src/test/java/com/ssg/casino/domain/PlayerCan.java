package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan {

    @Test
    public void enterTheGame() {
        Player player = new Player();

        player.enter(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveTheGame() {
        Player player = new Player();

        player.leave();

        assertFalse(player.isInGame);
    }

}
