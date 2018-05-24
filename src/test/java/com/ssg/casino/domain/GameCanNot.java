package com.ssg.casino.domain;

import org.junit.Test;

public class GameCanNot extends TestBase {
    @Test(expected = GameIsFullException.class)
    public void allowMoreThenSixPlayers () throws GameIsFullException {
        Game fullGame = newFullGame();
        Player seventhPlayer = newPlayer();

        fullGame.add(seventhPlayer);
    }

}
