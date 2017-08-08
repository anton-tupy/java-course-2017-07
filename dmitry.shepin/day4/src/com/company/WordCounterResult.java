package com.company;

import java.util.HashMap;

public class WordCounterResult {
    private int totalCount ;
    private HashMap<String, Integer> wordsCount;

    public WordCounterResult(int totalCount, HashMap<String, Integer> wordsCount) {
        this.totalCount = totalCount;
        this.wordsCount = wordsCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public HashMap<String, Integer> getWordsCount() {
        return wordsCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setWordsCount(HashMap<String, Integer> wordsCount) {
        this.wordsCount = wordsCount;
    }
}
