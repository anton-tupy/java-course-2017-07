package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class LineParser {

    public ParseResult parse(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }
        String[] lineWithoutComments = line.split("#");
        String[] items = new String[0];

        if (lineWithoutComments.length!=0) {
            items = lineWithoutComments[0].split(" ");
        }
        if (items.length == 0) {
            return null;
        }
        String commandName = items[0];
        ArrayList<String> arguments = new ArrayList<>();
        for (int i = 1; i < items.length; i++) {
            arguments.add(items[i]);
        }
        return new ParseResult(commandName, arguments);
    }

}
