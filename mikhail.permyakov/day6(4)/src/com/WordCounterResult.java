package com;

import java.util.HashMap;

/**
 * Created by lab on 29.07.2017.
 */
public class WordCounterResult {
    private int totalCount;
    private HashMap<String, Integer> wordsCount;

    public WordCounterResult(int totalCount, HashMap<String, Integer> wordsCount){
        this.totalCount = totalCount;
        this.wordsCount = wordsCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public HashMap<String, Integer> getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(HashMap<String, Integer> wordsCount) {
        this.wordsCount = wordsCount;
    }
}
