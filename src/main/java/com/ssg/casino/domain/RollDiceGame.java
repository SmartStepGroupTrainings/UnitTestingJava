package com.ssg.casino.domain;

import java.util.HashMap;

public class RollDiceGame {
    private HashMap<Player, Bet> playersBets = new HashMap<Player, Bet>();
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
                player.win(bet.getAmount() * createWinningFactorService().calculateWinningFactorInstance(winningScore));
            } else {
                player.lose();
                bankAmount += bet.getAmount();
            }
        }
        playersBets.clear();
    }

    protected WinningFactorService createWinningFactorService() {
        return new WinningFactorService();
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) {
            return;
        }

        playersBets.remove(player);
    }

    public int getBankAmount() {
        return bankAmount;
    }
}
