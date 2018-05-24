package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.HasMaxPlayersCountException;
import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.NotEnoughChipsException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PlayerCan extends Base {

    @Test
    public void enterTheGame() throws OnlyOneGameException, HasMaxPlayersCountException {
        Player player = newPlayerInSomeNewGame();

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveTheGame() throws CanNotLeaveTheGameException, OnlyOneGameException, HasMaxPlayersCountException {
        Player player = newPlayerInSomeNewGame();

        player.leave();

        assertFalse(player.isInGame);
    }

    @Test(expected = OnlyOneGameException.class)
    public void enterOnlyOneGame() throws OnlyOneGameException, HasMaxPlayersCountException {
        Player player = newPlayerInSomeNewGame();
        player.enter(new Game());
    }

    @Test
    public void buyChips() {
        Player player = newPlayer();

        player.buyChips(1);

        assertEquals(1, player.chips);
    }

    @Test
    public void doBetInGame() throws NotEnoughChipsException, OnlyOneGameException, HasMaxPlayersCountException {
        Player playerInGame = creator
                .newPlayer()
                .withGame(game)
                .withChips(10)
                .please();

        playerInGame.doBet(new Bet());


        assertFalse(playerInGame.bets.isEmpty());
    }

    @Test
    public void doBetsOnDifferentScore() throws NotEnoughChipsException, OnlyOneGameException, HasMaxPlayersCountException {
        Player playerInGame = creator
                .newPlayer()
                .withGame(game)
                .withChips(20)
                .please();

        playerInGame.doBet(new Bet(10, 2));
        playerInGame.doBet(new Bet(10, 3));

        assertTrue(playerInGame.bets.size() > 0);
    }
}
