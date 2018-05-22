package com.ssg.casino.domain;

public class BaseTest {
    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected RollDiceGame newRollDiceGameWithFakeWin(int score) {
        Dice dice = new DiceFake();
        ((DiceFake) dice).score = score;
        return new RollDiceGame(dice);
    }

    protected Player activePlayer(RollDiceGame game, int amountChips) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(game);
        newPlayer.buy(amountChips);
        return newPlayer;
    }

    protected Player activePlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newRollDiceGame());

        return player;
    }
}
