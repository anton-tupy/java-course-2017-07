package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by WizZo on 29.07.2017.
 */
public class WordStatisticsCalculator {
    List<WordsStatisticsRecord> calculate(WordCounterResult wordCount) {
        ArrayList<WordsStatisticsRecord> result = new ArrayList<>();

        for (String word : wordCount.getWordsCount().keySet()) {
            int count = wordCount.getWordsCount().get(word);
            float percent = (float) count / wordCount.getTotalCount() * 100;
            result.add(new WordsStatisticsRecord(word, count, percent));
        }
      //  result.sort(Comparator.comparing(r -> r.getCount(), Comparator.reverseOrder()));
        result.sort(new Comparator<WordsStatisticsRecord>() {
            @Override
            public int compare(WordsStatisticsRecord r1, WordsStatisticsRecord r2) {
                return -Integer.valueOf(r1.getCount()).compareTo(r2.getCount());
            }
        });
        return result;
    }
}
