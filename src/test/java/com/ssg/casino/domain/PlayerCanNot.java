package com.ssg.casino.domain;

import org.junit.Test;

/**
 * Created by ostkav15 24.05.18
 **/
public class PlayerCanNot extends  BaseTest{
    @Test(expected = PlayerNotInGameException.class)
    public void leaveGameIfNotInGame() throws PlayerNotInGameException {
        Player player = newPlayer();

        player.leaveGame();
    }
}
