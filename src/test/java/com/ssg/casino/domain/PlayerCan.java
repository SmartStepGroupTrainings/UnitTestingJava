package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by ostkav15 24.05.18
 **/
public class PlayerCan extends BaseTest {
    @Test
    public void joinGame() throws PlayerAlreadyInGameException, GameIsFullException {
        Player player = newPlayer();

        player.join(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveGame() throws PlayerNotInGameException, PlayerAlreadyInGameException, GameIsFullException {
        Player player = newPlayerInGame();

        player.leaveGame();

        assertFalse(player.isInGame);
    }

    @Test (expected = PlayerAlreadyInGameException.class)
    public void joinOnlyOneGame() throws PlayerAlreadyInGameException, GameIsFullException {
        Player player = newPlayerInGame();

        player.join(new Game());
    }

    @Test
    public void buyChipsFromCasino() {
        Player player = newPlayer();

        player.buy(10);

        assertTrue(player.hasChips());
    }

    @Test
    public void makeBetInGame() throws NotEnoughChipsException, GameIsFullException, PlayerAlreadyInGameException {
        Player player = richPlayerInGame();

        player.makeBet(1);

        assertTrue(player.hadBet());
    }

}