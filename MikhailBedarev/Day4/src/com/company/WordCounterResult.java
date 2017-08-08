package com.company;

import java.util.HashMap;

/**
 * Created by WizZo on 29.07.2017.
 */
public class WordCounterResult {
    private int totalCount;
    HashMap<String, Integer> wordsCount = new HashMap<>();

    public WordCounterResult(int totalCount, HashMap<String, Integer> wordsCount) {
        this.totalCount = totalCount;
        this.wordsCount = wordsCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

    }

    public void setWordsCount(HashMap<String, Integer> wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getTotalCount() {

        return totalCount;
    }

    public HashMap<String, Integer> getWordsCount() {
        return wordsCount;
    }

}
