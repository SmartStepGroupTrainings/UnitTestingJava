package com.ssg.casino.domain;

/**
 * Created by ostkav15 24.05.18
 **/
public class BaseTest {
    protected Player newPlayerInGame() throws PlayerAlreadyInGameException, GameIsFullException {
        Player player = newPlayer();

        player.join(new Game());
        return player;
    }

    protected Player newPlayer() {
        return new Player();
    }

    protected Game gameWithSixPlayers() throws GameIsFullException, PlayerAlreadyInGameException {
        Game game = new Game();
        Player player1 = newPlayer();
        Player player2 = newPlayer();
        Player player3 = newPlayer();
        Player player4 = newPlayer();
        Player player5 = newPlayer();
        Player player6 = newPlayer();

        player1.join(game);
        player2.join(game);
        player3.join(game);
        player4.join(game);
        player5.join(game);
        player6.join(game);

        return game;
    }

    protected Player richPlayerInGame() throws PlayerAlreadyInGameException, GameIsFullException {
        Player player = newPlayerInGame();
        player.buy(Integer.MAX_VALUE);
        return player;
    }
}
