package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class Game {
    private int playersCount = 0;

    public void accept(Player player) throws GameIsFullException {
        if (playersCount >= 6) {
            throw new GameIsFullException();
        }
        playersCount ++;
    }
}
