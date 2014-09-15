package com.cft.casino.domain;

public class Player {
    private Game activeGame;
    private int chips;

    public void joins(Game game) throws CasinoGameException {
        if (this.activeGame != null) {
            throw new CasinoGameException("Player must leave the current game before joining another game");
        }
        this.activeGame = game;
    }

    public Game activeGame() {
        return activeGame;
    }

    public void leave() {
        activeGame = null;
    }

    public void buyChips(int chips) {
        this.chips += chips;
    }

    public int getAvailableChips() {
        return chips;
    }

    public void bet(Bet bet) throws CasinoGameException {
        if (bet.getAmount() > this.chips) {
            throw new CasinoGameException("Can not bet more than chips available");
        }

        this.chips -= bet.getAmount();
        activeGame.addBet(this, bet);
    }
}
