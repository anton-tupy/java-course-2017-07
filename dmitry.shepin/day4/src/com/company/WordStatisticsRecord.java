package com.company;

public class WordStatisticsRecord {
    private String word;
    private  int count;
    private float percent;

    public WordStatisticsRecord(String word, int count, float percent) {
        this.word = word;
        this.count = count;
        this.percent = percent;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public float getPercent() {
        return percent;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
