package com.ssg.casino.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class РодительИгры {
    Dice dice;

    public РодительИгры всегдаСПобедой() {
        dice = mock(Dice.class);
        when(dice.getDice()).thenReturn(1);
        return this;
    }

    public RollDiceGame родить() {

        return new RollDiceGame(dice);
    }
}
