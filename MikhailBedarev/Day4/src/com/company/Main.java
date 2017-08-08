package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];

        WordCounter wordCounter = new WordCounter();
        WordCounterResult count = wordCounter.count(inputPath);

        WordStatisticsCalculator statisticsCalculator = new WordStatisticsCalculator();
        List<WordsStatisticsRecord> statistics = statisticsCalculator.calculate(count);

        WordStatisticsWriter statisticsWriter = new WordStatisticsWriter();
        statisticsWriter.write(outputPath, statistics);

    }
}
