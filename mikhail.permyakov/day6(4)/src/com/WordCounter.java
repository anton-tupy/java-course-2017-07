package com;

import java.io.*;
import java.util.HashMap;

/**
 * Created by lab on 29.07.2017.
 */
public class WordCounter {
    public WordCounterResult count(String inputPath){
        WordCounterResult wordCounterResult = new WordCounterResult(0, new HashMap<>());

        try (InputStreamReader reader =
                     new InputStreamReader(new BufferedInputStream(new FileInputStream(inputPath))))
                     {
                       StringBuilder sb = new StringBuilder();
                       while(true){
                           int value = reader.read();
                           if (value == -1){
                               break;
                           }
                           char c = (char)value;
                           if (Character.isLetterOrDigit(c)){
                               sb.append(c);
                           } else {
                               addWord(sb, wordCounterResult);
                           }
                       }
                       addWord(sb, wordCounterResult);
                     } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordCounterResult;
    }
    private void addWord(StringBuilder sb, WordCounterResult wordCounterResult){
        if (sb.length() == 0){
            return;
        }
        String word = sb.toString().toLowerCase();
        wordCounterResult.setTotalCount(wordCounterResult.getTotalCount() + 1);
        Integer wordCount = wordCounterResult.getWordsCount().get(word);
        if (wordCount == null){
            wordCounterResult.getWordsCount().put(word, 1);
        } else {
            wordCounterResult.getWordsCount().put(word, wordCount + 1);
        }
        sb.setLength(0);
    }
}
