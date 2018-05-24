package com.ssg.casino.domain;

import org.junit.Test;

public class PlayerCanNot extends TestBase {
    @Test(expected = PlayerIsNotInGame.class)
    public void exitTheGameIfHeIsNotInGame() throws PlayerIsNotInGame {
        Player player = newPlayer();

        player.exit();
    }
}
