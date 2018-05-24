package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.CanNotAddNewPlayerToTheGameException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Test;

public class GameCanNot extends Base{

    @Test(expected = CanNotAddNewPlayerToTheGameException.class)
    public void acceptMoreThanSixPlayers() throws OnlyOneGameException, CanNotAddNewPlayerToTheGameException {

        Game game = new Game();
        for (int i = 0; i < 7; i++) {
            newPlayerInGame(game);
        }
    }
}
