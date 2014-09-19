package com.cft.casino.domain;

public final class WinningFactorService {
    public static int calculateWinningFactor(int score) {
        switch(score) {
            case 4:
                return 2;
            case 5:
                return 10;
            default:
                return 6;
        }
    }
}
