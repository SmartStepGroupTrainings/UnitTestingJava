package com.cft.casino.domain.dsl;

import com.cft.casino.domain.RollDiceGame;

public class GameFather {
    public RollDiceGame please() {
        return new RollDiceGame();
    }
}
