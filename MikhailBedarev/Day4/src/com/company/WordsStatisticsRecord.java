package com.company;

/**
 * Created by WizZo on 29.07.2017.
 */
public class WordsStatisticsRecord {
    private String word;
    private int count;
    private float percent;

    public WordsStatisticsRecord(String word, int count, float percent) {

        this.word = word;
        this.count = count;
        this.percent = percent;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
