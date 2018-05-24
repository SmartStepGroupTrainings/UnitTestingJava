package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotAddNewPlayerToTheGameException;
import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PlayerCan extends Base {

    private ObjectFather creator = new ObjectFather();

    private Game game;

    @Before
    public void setUp() {
        game = new Game();

    }

    @Test
    public void enterTheGame() throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
        Player player = newPlayerInSomeNewGame();

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveTheGame() throws CanNotLeaveTheGameException, OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
        Player player = newPlayerInSomeNewGame();

        player.leave();

        assertFalse(player.isInGame);
    }

    @Test(expected = OnlyOneGameException.class)
    public void enterOnlyOneGame() throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {
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
    public void doBetInGame() {
        Player playerInGame = creator
                .newPlayer()
                .withGame(game)
                .withChips(10)
                .please();

        playerInGame.doBet(new Bet());


        assertNotNull(playerInGame.bet);
    }
}
