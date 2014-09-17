package com.cft.casino.domain;

import com.cft.casino.domain.dsl.Father;
import com.cft.casino.domain.dsl.PlayerAssert;
import com.cft.casino.domain.dsl.RollDiceGameAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WhenPlayRolDiceGame extends TestBase {
    private Father create;
    private Father a;

    @Before
    public void setup() {
        create = a = new Father();
    }

    @Test
    public void playerCanLose() throws Exception {
        RollDiceGame game = create.game().please();
        Player player = create.playerIn(game)
                .with(100).chips()
                .with(create.bet(25).on(1).please())
                .please();
        IDice dice = create.dice().rolling(5).please();

        game.play(dice);

        assertEquals(100 - 25, player.getAvailableChips());
    }

    @Test
    public void playerCanWin() throws Exception {
        Player player = createPlayer();
        RollDiceGame game = createGame();
        int WINNING_SCORE = 1;

        int INITIAL_AMOUNT = 100;
        player.buyChips(INITIAL_AMOUNT);
        player.joins(game);
        int BET_AMOUNT = 100;
        player.bet(new Bet(BET_AMOUNT, WINNING_SCORE));
        IDice dice = createDiceRolling(WINNING_SCORE);

        game.play(dice);

        int WIN_FACTOR = 6;
        assertEquals(INITIAL_AMOUNT - BET_AMOUNT + BET_AMOUNT * WIN_FACTOR, player.getAvailableChips());
    }

    @Test
    public void playerCanWinWithDsl() throws CasinoGameException {
        RollDiceGame game = create.game().please();
        Player player = create
                .winnerIn(game)
                .with(1000).chips()
                .withBet(100)
                .please();

        game.play(create.dice().please());

        assertThat(player).has(1000 - 100 + 100 * 6).chips();
    }

    @Test
    public void casinoCanWins() throws CasinoGameException {
        RollDiceGame game = create.game().please();
        create.looserIn(game)
                .with(1000).chips()
                .withBet(250)
                .please();

        game.play(create.dice().please());

        assertThat(game).has(250).chips();
    }

    @Test
    public void casinoCanWinsOneBetAndLoseAnother() throws CasinoGameException {
        int LUCKY_SCORE = 3;
        int UNLUCKY_SCORE = 1;
        RollDiceGame game = create.game().please();
        Player player = create.playerIn(game)
                .with(1000).chips()
                .with(a.bet(250).on(LUCKY_SCORE).please())
                .with(a.bet(350).on(UNLUCKY_SCORE).please())
                .please();
        IDice dice = create.dice().rolling(LUCKY_SCORE).please();

        game.play(dice);

        assertThat(player).has(1000 - 350 - 250 + 250 * 6).chips();
        assertThat(game).has(350).chips();
    }

    private PlayerAssert assertThat(Player player) {
        return new PlayerAssert(player);
    }

    private RollDiceGameAssert assertThat(RollDiceGame game) {
        return new RollDiceGameAssert(game);
    }

    @Test
    public void playerWins6Bets() throws CasinoGameException {
        RollDiceGame game = createGame();
        Player player = mock(Player.class);

        game.addBet(player, new Bet(100, 1));
        game.play(createDiceRolling(1));

        verify(player).win(100 * 6);
    }

    @Test
    public void playerLoses() throws CasinoGameException {
        RollDiceGame game = createGame();
        Player player = mock(Player.class);

        game.addBet(player, new Bet(100, 1));
        game.play(createDiceRolling(6));

        verify(player, never()).win(anyInt());
        verify(player).lose();
    }

    private IDice createDiceRolling(int WINNING_SCORE) {
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(WINNING_SCORE);
        return dice;
    }
}

