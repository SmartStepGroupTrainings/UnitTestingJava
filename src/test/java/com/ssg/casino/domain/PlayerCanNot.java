package com.ssg.casino.domain;

import org.junit.Test;

public class PlayerCanNot extends  BaseTest{
    @Test(expected = PlayerNotInGameException.class)
    public void leaveGameIfNotInGame() throws PlayerNotInGameException {
        Player player = newPlayer();

        player.leaveGame();
    }

    @Test(expected = NotEnoughChipsException.class)
    public void betMoreThanHave() throws GameIsFullException, PlayerAlreadyInGameException, NotEnoughChipsException {
        Player player = newPlayerInGame();
        player.buy(10);

        player.makeBet(10+1);
    }
}
