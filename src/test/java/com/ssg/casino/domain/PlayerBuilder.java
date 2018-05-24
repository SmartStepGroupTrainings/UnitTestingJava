package com.ssg.casino.domain;

import com.ssg.casino.domain.exceptions.HasMaxPlayersCountException;
import com.ssg.casino.domain.exceptions.OnlyOneGameException;

public class PlayerBuilder {


    private Game game;
    private int chips;


    public PlayerBuilder withGame(Game game) {
        this.game = game;
        return this;
    }

    public Player please() throws OnlyOneGameException, HasMaxPlayersCountException {
        Player player = new Player();
        player.enter(game);
        player.buyChips(chips);


        return player;
    }

    public PlayerBuilder withChips(int chips) {
        this.chips = chips;
        return this;
    }
}
