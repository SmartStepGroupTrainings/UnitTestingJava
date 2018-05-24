package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import org.junit.Test;

public class PlayerCanNot extends Base {

    @Test(expected = CanNotLeaveTheGameException.class)
    public void leaveTheGameIfHeIsNotInGame() throws CanNotLeaveTheGameException {
        Player player = newPlayer();

        player.leave();
    }
}
