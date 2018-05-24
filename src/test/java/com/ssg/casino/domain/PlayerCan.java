package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerCan extends Base {

    @Test
    public void enterTheGame() {
        Player player = newPlayer();

        player.enter(new Game());

        assertTrue(player.isInGame);
    }

    @Test
    public void leaveTheGame() throws CanNotLeaveTheGameException {
        Player player = newPlayer();
        player.enter(new Game());

        player.leave();

        assertFalse(player.isInGame);
    }

}
