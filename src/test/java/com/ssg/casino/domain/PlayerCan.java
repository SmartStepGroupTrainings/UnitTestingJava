package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ostkav15 24.05.18
 **/
public class PlayerCan extends BaseTest {
    @Test
    public void joinGame() throws PlayerAlreadyInGameException {
        Player player = newPlayer();

        player.join(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveGame() throws PlayerNotInGameException, PlayerAlreadyInGameException {
        Player player = newPlayerInGame();

        player.leaveGame();

        assertFalse(player.isInGame);
    }

    @Test (expected = PlayerAlreadyInGameException.class)
    public void joinOnlyOneGame() throws PlayerAlreadyInGameException {
        Player player = newPlayerInGame();

        player.join(new Game());
    }
}