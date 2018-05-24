package com.ssg.casino.domain;

import org.junit.Test;

public class PlayerCanNot extends TestBase {
    @Test(expected = PlayerIsNotInGameException.class)
    public void exitTheGameIfHeIsNotInGame() throws PlayerIsNotInGameException {
        Player player = newPlayer();

        player.exit();
    }
}
