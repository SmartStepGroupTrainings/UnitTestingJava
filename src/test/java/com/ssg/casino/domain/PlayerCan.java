package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ostkav15 24.05.18
 **/
public class PlayerCan {
    @Test
    public void joinGame() {
        Player player = new Player();

        player.join(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveGame() {
        Player player = new Player();

        player.leaveGame();

        assertFalse(player.isInGame);
    }
}