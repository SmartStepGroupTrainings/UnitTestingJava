package com.ssg.casino.domain;

import java.util.HashMap;
import java.util.Random;

public class RollDiceGame {
    private HashMap<Player, Bet> playersBets = new HashMap<Player, Bet>();
    private IDice dice;

    public RollDiceGame() {
    }

    public RollDiceGame(IDice dice) {
        this.dice = dice;
    }


    public void addBet(Player player, Bet bet) {
        playersBets.put(player, bet);
    }

    public void play() throws CasinoGameException {
        int rollsCount = dice.roll();
        int winningScore = 0;
        for (int i = 0; i < rollsCount; i++) {
            int rollsScore = dice.roll();
            if (i == rollsCount - 1) {
                winningScore = rollsScore;
            }
        }

        for (Player player : playersBets.keySet()) {
            Bet bet = playersBets.get(player);
            if (bet.getScore() == winningScore) {
                player.win(bet.getAmount() * 6);
            } else {
                player.lose();
            }
        }
        playersBets.clear();
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) {
            return;
        }

        playersBets.remove(player);
    }
}
