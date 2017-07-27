package com.company;


import java.io.*;

public class Calculator {

    public void run(String path){
        LineParse lineParse = new LineParse();
        CalculatorContext calculatorContext = new CalculatorContext();
        ContextInjactor contextInjactor = new ContextInjactor(calculatorContext);
        CommandFactory commandFactory = new CommandFactory(contextInjactor);
        BufferedReader reader = getBuff(path);
        String line;
        while (true){
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null){
                break;
            }
            ParseResauit parseResauit = lineParse.parse(line);
            if (parseResauit == null) {
                continue;
            }
            Comand comand = commandFactory.createCommand(parseResauit.getComandName());
            comand.execule(parseResauit.getArguments());
        }
    }

    private BufferedReader getBuff(String path){
        return new BufferedReader(getReaer(path));
    }

    private Reader getReaer(String path) {
        if (path == null) {
            return new InputStreamReader(System.in);
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                return new InputStreamReader(fileInputStream);
            }
             catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
