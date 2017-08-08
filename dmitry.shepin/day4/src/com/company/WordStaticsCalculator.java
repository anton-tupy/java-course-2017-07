package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordStaticsCalculator {

    List<WordStatisticsRecord> calculate(WordCounterResult wordCount) {

        ArrayList<WordStatisticsRecord> result = new ArrayList<>();

        for (String word : wordCount.getWordsCount().keySet()) {

            int count = wordCount.getWordsCount().get(word); //взять по ключу значение т.е. сколько это слово повторялось
            float percent = (float) count / wordCount.getTotalCount() * 100;
            WordStatisticsRecord cell = new WordStatisticsRecord(word, count, percent); //ячейка чтобы добавить ее а аррайлист
            result.add(cell);
        }

//        Function<WordStatisticsRecord, Integer> compareFunction = new Function<WordStatisticsRecord, Integer>() {
//            @Override
//            public Integer apply(WordStatisticsRecord r) {
//                return r.getCount();
//            }
//        };
//
//        result.sort(Comparator.comparing(r -> r.getCount(), Comparator.reverseOrder()));

        result.sort(new Comparator<WordStatisticsRecord>() {
            @Override
            public int compare(WordStatisticsRecord r1, WordStatisticsRecord r2) {
                return Integer.valueOf(r1.getCount()).compareTo(r2.getCount());
            }
        });

        return result;
    }
}

