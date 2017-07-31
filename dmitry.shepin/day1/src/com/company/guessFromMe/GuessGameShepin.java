package com.company.guessFromMe;

import java.util.Random;


/**
 * Created by Dmitry on 16.07.2017.
 */
public class GuessGameShepin {

    private int maxNumberOfAttempts;
    private int triesCount;
    private int randomNumber;

    public GuessGameShepin(int maxNumberOfAttempts, int maxNumber) {
        this.randomNumber = new Random().nextInt(maxNumber);
        this.maxNumberOfAttempts = maxNumberOfAttempts;
    }


    public TryResult doTry(int inputNumber) {
        triesCount++;
        if (triesCount > maxNumberOfAttempts) {
            return TryResult.FAIL;
        }

        if (inputNumber < randomNumber) {
            return TryResult.LESS;
        }

        if (inputNumber > randomNumber) {
            return TryResult.MORE;
        } else {
            return TryResult.SUCCESS;
        }

    }

    public int getMaxNumberOfAttempts() {
        return maxNumberOfAttempts;
    }

    public int getTriesCount() {
        return triesCount;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
