package com.ssg.casino.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlayerCan {
    @Test
    public void enterInGame() {
        Player player = new Player();

        player.enter(new Game());

        assertTrue(player.isInGame);
    }
}
