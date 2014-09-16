package com.cft.casino.domain;

public class Player {
    private RollDiceGame activeGame;
    private int chips;

    public void joins(RollDiceGame game) throws CasinoGameException {
        if (this.activeGame != null) {
            throw new CasinoGameException("Player must leave the current game before joining another game");
        }
        this.activeGame = game;
    }

    public RollDiceGame activeGame() {
        return activeGame;
    }

    public void leave() throws CasinoGameException {
        activeGame.leave(this);
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
