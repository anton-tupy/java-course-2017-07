package com.company;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = args[0];
        String outputPath = args[1];

        WordCounter wordCounter = new WordCounter();
        WordCounterResult count = wordCounter.count(inputPath); // в каунте хранится общее кол-во слов и все слова с их кол-вом

        WordStaticsCalculator staticsCalculator = new WordStaticsCalculator();
        List<WordStatisticsRecord> statistics = staticsCalculator.calculate(count);

        WordStatisticsWriter StatisticsWriter = new WordStatisticsWriter();
        StatisticsWriter.write(outputPath, statistics);
    }
}
