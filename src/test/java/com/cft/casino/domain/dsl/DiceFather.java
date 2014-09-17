package com.cft.casino.domain.dsl;

import com.cft.casino.domain.IDice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceFather {
    private Father create;
    private int luckyScore;

    public DiceFather(Father create) {
        this.create = create;
        this.luckyScore = create.LUCKY_SCORE;
    }

    public IDice please() {
        IDice dice = mock(IDice.class);
        when(dice.roll()).thenReturn(luckyScore);
        return dice;
    }

    public DiceFather rolling(int luckyScore) {
        this.luckyScore = luckyScore;
        return this;
    }
}
