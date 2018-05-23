package com.ssg.casino.domain;

public class BaseTest {
    private static int WIN_SCORE = 1;

    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected RollDiceGame newFakeGameForWin() {
        Dice dice = new DiceFake();
        ((DiceFake) dice).score = WIN_SCORE;
        return new RollDiceGame(dice);
    }

    protected Player activePlayer(RollDiceGame game, int amountChips) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(game);
        newPlayer.buy(amountChips);
        return newPlayer;
    }

    protected Bet doBetForWin(int amountChips) {
        return new Bet(amountChips, WIN_SCORE);
    }

    protected Player activePlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newRollDiceGame());

        return player;
    }
}
