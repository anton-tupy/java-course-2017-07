package com.company;

import com.company.commands.ContextInjector;

import java.io.*;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class Calculator {

    public void run(String path) throws IOException {
        LineParser lineParser = new LineParser();
        CalculatorContext calculatorContext = new CalculatorContext();
        ContextInjector contextInjector = new ContextInjector(calculatorContext);
        CommandFactory commandFactory = new CommandFactory(contextInjector);
        BufferedReader reader = getBufferedReader(path);
        //CalculatorContext calculatorContext = new CalculatorContext();
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
            String StringParseResult1 = parseResult.getCommandName();
            Command command = commandFactory.createCommand(StringParseResult1);
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
