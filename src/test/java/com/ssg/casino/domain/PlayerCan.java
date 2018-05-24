package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan extends Base {

    @Test
    public void enterTheGame() throws OnlyOneGameException {
        Player player = newPlayerInGame();

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveTheGame() throws CanNotLeaveTheGameException, OnlyOneGameException {
        Player player = newPlayerInGame();

        player.leave();

        assertFalse(player.isInGame);
    }

    @Test(expected = OnlyOneGameException.class)
    public void enterOnlyOneGame() throws OnlyOneGameException {
        Player player = newPlayerInGame();
        player.enter(new Game());
    }
}
