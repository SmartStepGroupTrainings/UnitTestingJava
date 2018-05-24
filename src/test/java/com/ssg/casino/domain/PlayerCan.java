package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ostkav15 24.05.18
 **/
public class PlayerCan extends BaseTest {
    @Test
    public void joinGame() {
        Player player = newPlayer();

        player.join(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveGame() throws PlayerNotInGameException {
        Player player = newPlayerInGame();

        player.leaveGame();

        assertFalse(player.isInGame);
    }
}