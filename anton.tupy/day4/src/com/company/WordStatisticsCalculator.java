package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IT-Academy on 29.07.2017.
 */
public class WordStatisticsCalculator {
    List<WordStatisticsRecord> calculate(WordCounterResult wordCount) {
        ArrayList<WordStatisticsRecord> result = new ArrayList<>();

        for (String word : wordCount.getWordsCount().keySet()) {
            int count = wordCount.getWordsCount().get(word);
            float percent = (float)count / wordCount.getTotalCount() * 100;
            result.add(new WordStatisticsRecord(word, count, percent));
        }

        //result.sort(Comparator.comparing(r -> r.getCount(), Comparator.reverseOrder()));

        result.sort(new Comparator<WordStatisticsRecord>() {
            @Override
            public int compare(WordStatisticsRecord r1, WordStatisticsRecord r2) {
                return -Integer.valueOf(r1.getCount()).compareTo(r2.getCount());
            }
        });

        return result;
    }
}
