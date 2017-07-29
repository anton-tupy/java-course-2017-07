package com;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];

        WordCounter wordCounter = new WordCounter();
        WordCounterResult count = wordCounter.count(inputPath);

        WordStatisticsCalculator wordStatisticsCalculator = new WordStatisticsCalculator();
        List<WordStatisticsRecord> statistics = wordStatisticsCalculator.calculate(count);

        WordStatisticsWriter statisticsWriter = new WordStatisticsWriter();
        statisticsWriter.write(outputPath, statistics);
    }
}
