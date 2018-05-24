package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan extends TestBase {
    @Test
    public void enterInGame() throws PlayerIsInGame {
        Player player = newPlayer();

        player.enter(newGame());

        assertTrue(player.isInGame);
    }

    @Test
    public void exitFromGame() throws PlayerIsNotInGame, PlayerIsInGame {
        Player player = newPlayerInGame();

        player.exit();

        assertFalse(player.isInGame);
    }



    @Test(expected = PlayerIsInGame.class)
    public void playOnlyOneGame() throws PlayerIsInGame {
       Player player = newPlayerInGame();

       player.enter(newGame());
    }
}
