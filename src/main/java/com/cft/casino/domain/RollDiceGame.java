package com.cft.casino.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RollDiceGame {
    private HashMap<Player, ArrayList<Bet>> playersBets = new HashMap<>();
    
    public void addBet(Player player, Bet bet) {
        if (!playersBets.containsKey(player)) {
            playersBets.put(player, new ArrayList<>());
        }
        playersBets.get(player).add(bet);
    }

    public ArrayList<Bet> getBetsFor(Player player) {
        return playersBets.get(player);
    }

    public void play() {
        Random random = new Random();
        int winningScore = 1 + random.nextInt(6);
        for (HashMap.Entry<Player, ArrayList<Bet>> playerBets : playersBets.entrySet()) {
            for (Bet bet : playerBets.getValue()) {
                if (bet.getScore() == winningScore) {
                    Player player = playerBets.getKey();
                    player.buyChips(bet.getAmount() * 6);
                }
            }
        }
        for (ArrayList<Bet> bets : playersBets.values()) {
            bets.clear();
        }
    }

    public void leave(Player player) throws CasinoGameException {
        if (!playersBets.containsKey(player)) return;
        if (playersBets.get(player).size() != 0) throw new CasinoGameException("You can't leave game after bet");

        playersBets.remove(player);
    }
}
