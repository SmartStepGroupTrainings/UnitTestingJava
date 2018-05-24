package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.HasMaxPlayersCountException;
import com.ssg.casino.domain.exceptions.CanNotLeaveTheGameException;
import com.ssg.casino.domain.exceptions.NotEnoughChipsException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;
import org.junit.Test;

public class PlayerCanNot extends Base {

    @Test(expected = CanNotLeaveTheGameException.class)
    public void leaveTheGameIfHeIsNotInGame() throws CanNotLeaveTheGameException {
        Player player = newPlayer();

        player.leave();
    }

    @Test(expected = NotEnoughChipsException.class)
    public void betMoreChipsThanHeHas() throws NotEnoughChipsException, OnlyOneGameException, HasMaxPlayersCountException {
        Player playerInGame = creator
                .newPlayer()
                .withGame(game)
                .withChips(10)
                .please();

        playerInGame.doBet(new Bet(10 + 1));
    }
}
