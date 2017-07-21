package com.company;

import java.io.*;

public class Calculator {
    public void run(String path) {
        LineParser lineParser = new LineParser();
        CommandFactory commandFactory = new CommandFactory();
        BufferedReader reader = getBufferedReader(path);
        CalculatorContext calculatorContext = new CalculatorContext();
        String line;
        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) {
                break;
            }
            ParseResult parseResult = lineParser.parse(line);
            if (parseResult == null) {
                continue;
            }
            Command command = commandFactory.createCommand(parseResult.getCommandName());
            command.execute(parseResult.getArguments(), calculatorContext);
        }
    }

    private BufferedReader getBufferedReader(String path) {
        return new BufferedReader(getReader(path));
    }

    private Reader getReader(String path) {
        if (path == null) {
            return new InputStreamReader(System.in);
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);//открытие потока
                return new InputStreamReader(fileInputStream); //считывание информации из файла
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
