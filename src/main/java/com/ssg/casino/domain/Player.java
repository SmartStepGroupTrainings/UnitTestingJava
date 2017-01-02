package com.ssg.casino.domain;

public class Player {
    private RollDiceGame activeGame;
    private int chips;

    public RollDiceGame activeGame() {
        return activeGame;
    }

    public int getAvailableChips() {
        return chips;
    }

    private boolean isInGame() {
        return activeGame != null;
    }

    public void joins(RollDiceGame game) throws CasinoGameException {
        if (isInGame()) {
            throw new CasinoGameException("Player must leave the current game before joining another game");
        }

        activeGame = game;
    }

    public void leave() throws CasinoGameException {
        activeGame.leave(this);
        activeGame = null;
    }

    public void buy(int chips) throws CasinoGameException {
        if (chips < 0) {
            throw new CasinoGameException("Buying negative numbers is not allowed");
        }

        this.chips += chips;
    }

    public void bet(Bet bet) throws CasinoGameException {
        if (bet.getAmount() > this.chips) {
            throw new CasinoGameException("Can not bet more than chips available");
        }

        this.chips -= bet.getAmount();
        activeGame.addBet(this, bet);
    }

    public void win(int chips) {
        this.chips += chips;
    }

    public void lose() {
    }
}
