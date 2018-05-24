package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan extends TestBase {
    @Test
    public void enterInGame() throws PlayerIsInGameException {
        Player player = newPlayer();

        player.enter(newGame());

        assertTrue(player.isInGame);
    }

    @Test
    public void exitFromGame() throws PlayerIsNotInGameException, PlayerIsInGameException {
        Player player = newPlayerInGame();

        player.exit();

        assertFalse(player.isInGame);
    }



    @Test(expected = PlayerIsInGameException.class)
    public void playOnlyOneGame() throws PlayerIsInGameException {
       Player player = newPlayerInGame();

       player.enter(newGame());
    }
}
