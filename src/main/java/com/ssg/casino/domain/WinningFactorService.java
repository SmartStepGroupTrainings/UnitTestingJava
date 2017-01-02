package com.ssg.casino.domain;

public class WinningFactorService {
    public static int calculateWinningFactor(int score) {
        switch (score) {
            case 4:
                return 2;
            case 5:
                return 10;
            default:
                return 6;
        }
    }

    public int calculateWinningFactorInstance(int score) {
        return WinningFactorService.calculateWinningFactor(score);
    }
}