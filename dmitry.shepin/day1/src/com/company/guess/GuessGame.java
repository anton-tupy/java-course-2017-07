package com.company.guess;

import java.util.Random;

/**
 * Created by IT-Academy on 15.07.2017.
 */
public class GuessGame {

    private final int maxTries;
    private int triesCount;
    private int number;

    public GuessGame(int maxTries, int maxNumber) {
        this.maxTries = maxTries;
        this.number = new Random().nextInt(maxNumber);
    }

    public enum TryResult {
        SUCCESS,
        LESS,
        MORE,
        FAIL
    }

    public TryResult doTry(int tryNumber) {
        triesCount++;
        if (triesCount > maxTries) {
            return TryResult.FAIL;
        }

        if (tryNumber < number) {
            return TryResult.LESS;
        }
        if (tryNumber > number) {
            return TryResult.MORE;
        }
        return TryResult.SUCCESS;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public int getTriesCount() {
        return triesCount;
    }

    public int getNumber() {
        return number;
    }
}
