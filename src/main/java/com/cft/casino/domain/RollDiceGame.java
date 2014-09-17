package com.cft.casino.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RollDiceGame {
    private HashMap<Player, ArrayList<Bet>> playersBets = new HashMap<>();
    private int bankAmount;

    public void addBet(Player player, Bet bet) {
        if (!playersBets.containsKey(player)) {
            playersBets.put(player, new ArrayList<>());
        }
        playersBets.get(player).add(bet);
    }

    public ArrayList<Bet> getBetsFor(Player player) {
        return playersBets.get(player);
    }

    public void play(IDice dice) throws CasinoGameException {
        int winningScore = roll(dice);

        for (HashMap.Entry<Player, ArrayList<Bet>> playerBets : playersBets.entrySet()) {
            Player player = playerBets.getKey();
            for (Bet bet : playerBets.getValue()) {
                if (bet.getScore() == winningScore) {
                    player.win(bet.getAmount() * 6);
                }
                else {
                    player.lose();
                    bankAmount += bet.getAmount();
                }
            }
        }
        for (ArrayList<Bet> bets : playersBets.values()) {
            bets.clear();
        }
    }

    private int roll(IDice dice) {
        return dice.roll();
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) return;
        if (playersBets.get(player).size() != 0) throw new CasinoGameException("You can't leave game after bet");

        playersBets.remove(player);
    }

    public int getBankAmount() {
        return bankAmount;
    }
}
