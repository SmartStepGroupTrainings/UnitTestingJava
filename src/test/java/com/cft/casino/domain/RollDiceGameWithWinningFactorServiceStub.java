package com.cft.casino.domain;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RollDiceGameWithWinningFactorServiceStub extends RollDiceGame {
    public int WINNING_FACTOR = 1;

    @Override
    protected WinningFactorService createWinningFactorService() {
        WinningFactorService winningFactorService = mock(WinningFactorService.class);
        when(winningFactorService.calculateWinningFactorInstance(anyInt())).thenReturn(WINNING_FACTOR);
        return winningFactorService;
    }
}
