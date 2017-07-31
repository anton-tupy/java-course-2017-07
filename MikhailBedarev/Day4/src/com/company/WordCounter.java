package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by WizZo on 29.07.2017.
 */
public class WordCounter {
    public WordCounterResult count(String inputPath) {
        WordCounterResult result = new WordCounterResult(0, new HashMap<>());

        try (InputStreamReader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(inputPath)))) {
            StringBuilder buffer = new StringBuilder();
            while (true) {
                int value = reader.read();
                if (value == -1) {
                    break;
                }
                char c = (char) value;
                if (Character.isLetterOrDigit(c)) {
                    buffer.append(c);
                } else {
                    addWord(buffer, result);
                }
            }
            addWord(buffer, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void addWord(StringBuilder buffer, WordCounterResult result) {
        if (buffer.length() == 0) {
            return;
        }
        String word = buffer.toString().toLowerCase();

        result.setTotalCount(result.getTotalCount() + 1);

        Integer wordsCount = result.getWordsCount().get(word);
        if (wordsCount == null) {
            result.getWordsCount().put(word, 1);
        } else {
            result.getWordsCount().put(word, wordsCount + 1);
        }
        buffer.setLength(0);
    }
}
