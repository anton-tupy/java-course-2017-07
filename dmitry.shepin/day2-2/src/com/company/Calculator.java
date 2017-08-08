package com.company;

import com.company.parsers.LineParser;
import com.company.parsers.ParseResult;

import java.io.*;

public class Calculator {
    public void run(String path) throws ClassNotFoundException {
        LineParser lineParser = new LineParser();

        CalculatorContext calculatorContext = new CalculatorContext();

        CalculatorStack calculatorStack = new CalculatorStack();

        ContextInjector contextInjector = new ContextInjector(calculatorContext, calculatorStack);

        CommandFactory commandFactory = new CommandFactory(contextInjector);

        try (BufferedReader reader = getBufferedReader(path);) {
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
                command.execute(parseResult.getArguments());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private BufferedReader getBufferedReader(String path) {
        BufferedReader reader = new BufferedReader(getReader(path));
        return reader;
    }

    private Reader getReader(String path) {
        if (path == null) {
            System.out.println("Введите команду и аргумент:");
            return new InputStreamReader(System.in);
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);//открытие потока(входной поток читающий из файла)
                return new InputStreamReader(fileInputStream); //считывание информации из файла
                /**
                 * InputStreamReader-Входной поток транслир байты в символы(класс символьн потоков)
                 * fileInputStream-входной поток читающий из файла(класс байтовых потоков)
                 * */
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
