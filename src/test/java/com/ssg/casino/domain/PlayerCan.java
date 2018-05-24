package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void buyChips() {
        Player player = newPlayer();

        player.buy(10);

        assertTrue(player.getChips() > 0);
    }

    @Test
    public void doBetInGame() throws PlayerIsInGameException {
        Player playerInGame = newPlayerInGame();

        playerInGame.doBet();

        assertNotNull(playerInGame.getBet());
    }
}
