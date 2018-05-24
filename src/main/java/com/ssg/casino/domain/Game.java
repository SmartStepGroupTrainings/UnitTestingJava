package com.ssg.casino.domain;

public class Game {
    Player[] players = new Player[6];
    int index = 0;

    public void add(Player player) throws GameIsFullException {
        if (index >= 6) throw new GameIsFullException();
        players[index++] = player;
    }
}
