package com.company;

import java.io.*;
import java.util.HashMap;

/**
 * Created by IT-Academy on 29.07.2017.
 */
public class WordCounter {
    public WordCounterResult count(String inputPath) {
        WordCounterResult result = new WordCounterResult(0, new HashMap<>());

        try(InputStreamReader reader =
                    new InputStreamReader(new BufferedInputStream(new FileInputStream(inputPath)))) {
            StringBuilder buffer = new StringBuilder();
            while(true) {
                int value = reader.read();
                if (value == -1) {
                    break;
                }
                char c = (char)value;
                if (Character.isLetterOrDigit(c)) {
                    buffer.append(c);
                }
                else {
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

        Integer wordCount = result.getWordsCount().get(word);
        if (wordCount == null) {
            result.getWordsCount().put(word, 1);
        }
        else {
            result.getWordsCount().put(word, wordCount + 1);
        }

        buffer.setLength(0);
    }
}
