package com.cft.casino.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
        int winningScore = roll(dice);

        for (HashMap.Entry<Player, Bet> playerBets : playersBets.entrySet()) {
            Player player = playerBets.getKey();
            Bet bet = playerBets.getValue();
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

    private int roll(IDice dice) {
        return dice.roll();
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) return;
        playersBets.remove(player);
    }

    public int getBankAmount() {
        return bankAmount;
    }
}
