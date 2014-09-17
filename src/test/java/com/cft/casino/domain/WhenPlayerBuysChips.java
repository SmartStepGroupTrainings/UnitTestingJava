package com.cft.casino.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenPlayerBuysChips extends TestBase {
    @Test
    public void heCanBuy100Chips() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(100);

        assertEquals(100, player.getAvailableChips());
    }

    @Test
    public void heCanBuyZeroChips() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(0);

        assertEquals(0, player.getAvailableChips());
    }

    @Test
    public void heCanBuyChipsMultipleTimes() throws CasinoGameException {
        Player player = createPlayer();

        player.buyChips(100);
        player.buyChips(150);

        assertEquals(100 + 150, player.getAvailableChips());
    }

    @Test
    public void heCanNotBuyNegativeChips() {
        Player player = createPlayer();

        expectCasinoGameException(
                () -> player.buyChips(-100),
                "Buying negative numbers is not allowed");
    }
}
