package com.company.parsers;

import java.util.ArrayList;

public class LineParser {
    public ParseResult parse(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }

//        int index=0;
//        while (true){
//            index= line.indexOf(' ',index);
//
//        }

        String[] items = line.split(" ");
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
