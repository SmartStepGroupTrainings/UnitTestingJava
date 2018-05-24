package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.HasMaxPlayersCountException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Before;

public class Base {

    protected ObjectFather creator = new ObjectFather();

    protected Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    protected Player newPlayer() {
        return new Player();
    }

    protected Player newPlayerInSomeNewGame() throws OnlyOneGameException, HasMaxPlayersCountException {
        Player player = newPlayer();
        player.enter(new Game());
        return player;
    }

    protected Player newPlayerInGame(Game game) throws OnlyOneGameException, HasMaxPlayersCountException {
        Player player = newPlayer();
        player.enter(game);
        return player;
    }
}
