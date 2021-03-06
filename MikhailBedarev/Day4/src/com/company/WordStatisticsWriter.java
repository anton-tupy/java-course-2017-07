package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by WizZo on 29.07.2017.
 */
public class WordStatisticsWriter {
    public void write(String outputPath, List<WordsStatisticsRecord> statistics){
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputPath))){
            for(WordsStatisticsRecord statistic : statistics){
                writer.write(String.format("%s,%s,%s",statistic.getWord(),statistic.getCount(),statistic.getPercent()));
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
