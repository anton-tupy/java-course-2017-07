package com.company;

import java.io.*;

/**
 * Created by WizZo on 20.07.2017.
 */
public class Calculator {
    public void run(String path) {
        LineParser lineParser = new LineParser();
        CalculatorContext calculatorContext = new CalculatorContext();
        CalculatorStack calculatorStack = new CalculatorStack();
        ContextInjector contextInjector = new ContextInjector(calculatorContext, calculatorStack);
        CommandFactory commandFactory = new CommandFactory(contextInjector);
        try (BufferedReader reader = getBufferedReader(path)) {
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
        return new BufferedReader(getReader(path));
    }

    private Reader getReader(String path) {
        if (path == null) {
            return new InputStreamReader(System.in);
        } else {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(path);
                return new InputStreamReader(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
