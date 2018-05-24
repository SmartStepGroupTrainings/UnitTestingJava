package com.ssg.casino.domain;

import org.junit.Test;


public class GameShouldNot extends BaseTest{

    @Test(expected = GameIsFullException.class)
    public void allowJoinMoreThenSixPlayers() throws PlayerAlreadyInGameException, GameIsFullException {
        Game fullGame =  gameWithSixPlayers();
        Player seventhPlayer = newPlayer();

        seventhPlayer.join(fullGame);

    }
}
