package com.ssg.casino.domain;

public class BaseTest {
    private static int WIN_SCORE = 1;
    private static int LOSE_SCORE = 2;

    protected Player newPlayer() {
        return new Player();
    }

    protected RollDiceGame newRollDiceGame() {
        return new RollDiceGame();
    }

    protected RollDiceGame newGameForWin() {
        Dice dice = new DiceFake();
        ((DiceFake) dice).score = WIN_SCORE;
        return new RollDiceGame(dice);
    }

    protected RollDiceGame newGameForLose() {
        Dice dice = new DiceFake();
        ((DiceFake) dice).score = LOSE_SCORE;
        return new RollDiceGame(dice);
    }

    protected Player activeReachPlayer(RollDiceGame game) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.joins(game);
        newPlayer.buy(Integer.MAX_VALUE);
        return newPlayer;
    }

    protected Bet doBet(int amountChips) {
        return new Bet(amountChips, WIN_SCORE);
    }

    protected Player activeReachPlayer() throws CasinoGameException {
        Player player = newPlayer();
        player.joins(newRollDiceGame());

        return player;
    }
}
