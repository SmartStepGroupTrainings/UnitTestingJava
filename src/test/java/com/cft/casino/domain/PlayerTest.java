package com.cft.casino.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PlayerTest {
    @Test
    public void buyChips_1_setsAvailableChipsTo1() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(1);

        assertEquals(1, player.getAvailableChips());
    }

    @Test
    public void buyChips_100_setsAvailableChipsTo100() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(100);

        assertEquals(100, player.getAvailableChips());
    }

    @Test
    public void buyChips_2Times_addsToAvailableChips() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(1);
        player.buyChips(2);

        assertEquals(1+2, player.getAvailableChips());
    }

    @Test(expected = CasinoGameException.class)
    public void buyChips_negative_throwsCasinoGameException() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(-1);
    }

    @Test
    public void buyChips_negative_throwsCasinoGameExceptionWithMessage() throws CasinoGameException {
        final Player player = createPlayer();

        IAction playerBuysNegativeChips = new IAction() {
            @Override
            public void run() throws Exception {
                player.buyChips(-1);
            }
        };

        expect_CasinoGameException(playerBuysNegativeChips);
    }

    private void expect_CasinoGameException(IAction action) {
        try {
            action.run();
            fail("CasinoGameException expected but was not thrown");
        }
        catch (CasinoGameException e) {
            assertEquals("Buying negative numbers is not allowed", e.getMessage());
        }
        catch (Exception e) {
            fail("CasinoGameException expected but " + e.getClass() + " was thrown");
        }
    }

    private Player createPlayer() {
        return new Player();
    }
}

