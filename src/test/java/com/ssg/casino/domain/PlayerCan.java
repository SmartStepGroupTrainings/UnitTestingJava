package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan extends TestBase {
    @Test
    public void enterInGame() {
        Player player = newPlayer();

        player.enter(newGame());

        assertTrue(player.isInGame);
    }

    @Test
    public void exitFromGame() throws PlayerIsNotInGame {
        Player player = newPlayer();
        player.enter(newGame());

        player.exit();

        assertFalse(player.isInGame);
    }
}
