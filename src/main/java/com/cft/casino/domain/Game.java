package com.cft.casino.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {
    private HashMap<Player, ArrayList<Bet>> bets = new HashMap<>();
    public ArrayList<Bet> getBetsFor(Player player) {
        return bets.get(player);
    }

    public void addBet(Player player, Bet bet) {
        if (!bets.containsKey(player)) {
            bets.put(player, new ArrayList<>());
        }
        bets.get(player).add(bet);
    }

    public void play() {
        Random random = new Random();
        int winningScore = 1 + random.nextInt(6);
        for (HashMap.Entry<Player, ArrayList<Bet>> playerBets : bets.entrySet()) {
            for (Bet bet : playerBets.getValue()) {
                if (bet.getScore() == winningScore) {
                    Player player = playerBets.getKey();
                    player.buyChips(bet.getAmount() * 6);
                }
            }
        }
    }
}
