package com.cft.casino.domain;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestBase {
    protected void expectCasinoGameException(IAction action, String expectedMessage) {
        try {
            action.run();
            fail("CasinoGameException was expected but was not thrown");
        }
        catch (CasinoGameException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
        catch (Exception e) {
            fail("CasinoGameException was expected but another exception " + e.getClass() + " was thrown");
        }
    }

    protected Player createPlayer() {
        return new Player();
    }

    protected RollDiceGame createGame() {
        return new RollDiceGame();
    }
}
