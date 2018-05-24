package com.ssg.casino.domain;

import org.junit.Test;

public class GameCanNot extends TestBase {
    @Test(expected = GameIsFull.class)
    public void allowMoreThenSixPlayers () throws GameIsFull {
        Game game = newFullGame();

        game.add(newPlayer());
    }

}
