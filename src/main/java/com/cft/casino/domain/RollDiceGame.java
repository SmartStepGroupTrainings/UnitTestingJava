package com.cft.casino.domain;

import java.util.HashMap;

public class RollDiceGame {
    private HashMap<Player, Bet> playersBets = new HashMap<>();
    private int bankAmount;

    public void addBet(Player player, Bet bet) {
        playersBets.put(player, bet);
    }

    public Bet getBetFor(Player player) {
        return playersBets.get(player);
    }

    public void play(IDice dice) throws CasinoGameException {
        int winningScore = dice.roll();

        for (Player player : playersBets.keySet()) {
            Bet bet = playersBets.get(player);
            if (bet.getScore() == winningScore) {
                player.win(bet.getAmount() * 6);
            }
            else {
                player.lose();
                bankAmount += bet.getAmount();
            }
        }
        playersBets.clear();
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) return;
        playersBets.remove(player);
    }

    public int getBankAmount() {
        return bankAmount;
    }
}
