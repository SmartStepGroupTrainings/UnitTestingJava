package com.cft.casino.domain;

public class Player {
    private Game activeGame;
    private boolean hasChips;

    public void joins(Game game) throws GameJoinException {
        if (this.activeGame != null) {
            throw new GameJoinException("com.cft.casino.Player must leave the current game before joining another game");
        }
        this.activeGame = game;
    }

    public Game activeGame() {
        return activeGame;
    }

    public void leave() {
        activeGame = null;
    }

    public boolean hasChips() {
        return this.hasChips;
    }

    public void buyChips(int chips) {
        hasChips = true;
    }
}
