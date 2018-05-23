package com.ssg.casino.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by ostkav15 22.05.18
 **/
public class WhenPlayerPlays extends BaseTest {

    private RollDiceGame newRollDiceGameWithKnownScore(final int winsScore) {
        return new RollDiceGame(new IDice() {
            public int roll() {
                return winsScore;
            }
        });
    }

    private Player newPlayerWithChipsJoinsGameAndBetForScore(int chipsAmount, int betScore, RollDiceGame game) throws CasinoGameException {
        Player newPlayer = newPlayer();
        newPlayer.buy(chipsAmount);
        newPlayer.joins(game);
        newPlayer.bet(new Bet(chipsAmount, betScore));
        return newPlayer;
    }

    @Test
    public void heWinTheGameWithTenChipsBet() throws CasinoGameException {
        RollDiceGame game = newRollDiceGameWithKnownScore(1);
        Player newPlayer = newPlayerWithChipsJoinsGameAndBetForScore(10, 1, game);

        game.play();

        assertEquals(10*6, newPlayer.getAvailableChips());
    }

    @Test
    public void heLoseTheGameWithTenChipsBet() throws CasinoGameException {
        RollDiceGame game = newRollDiceGameWithKnownScore(2);
        Player newPlayer = newPlayerWithChipsJoinsGameAndBetForScore(10, 2+1, game);

        game.play();

        assertEquals(0, newPlayer.getAvailableChips());
    }
}
