package com.company;

import java.io.*;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class Calculator {

    public void run(String path) {
        LineParser lineParser = new LineParser();
        CalculatorContext calculatorContext = new CalculatorContext();
        ContextInjector contextInjector = new ContextInjector(calculatorContext);
        CommandFactory commandFactory = new CommandFactory(contextInjector);
        BufferedReader reader = getBufferedReader(path);
        String line;
        while(true) {
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
    }

    private BufferedReader getBufferedReader(String path) {
        return new BufferedReader(getReader(path));
    }

    private Reader getReader(String path) {
        if (path == null) {
            return new InputStreamReader(System.in);
        }
        else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                return new InputStreamReader(fileInputStream);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
