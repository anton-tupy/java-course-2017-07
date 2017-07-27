package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommandFactory {

    private Properties properties;
    private ContextInjector contextInjector;


    public CommandFactory(ContextInjector contextInjector) {
        this.contextInjector = contextInjector;
        try {
            InputStream resourceStream = CommandFactory.class.getResourceAsStream("commands.properties");
            properties = new Properties();
            properties.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public Command createCommand(String commandName) throws ClassNotFoundException {

        try {
            String className = properties.getProperty(commandName.toUpperCase());
            if (className == null) {
                throw new RuntimeException("Unexpected command: " + commandName);
            }
            Class<?> aClass = Class.forName(className);
            Object commandObj = aClass.newInstance();

            contextInjector.inject(commandObj);

            return (Command) commandObj;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }


//        switch (commandName.toUpperCase()) {
//            case "PUSH":
//                return new PushCommand();
//            case "PRINT":
//                return new PrintCommand();
//            case "POP":
//                return new PopCommand();
//            case "SQRT":
//                return new SqrtCommand();
//            case "+":
//                return new AdditionCommand();
//            case "-":
//                return new SubtractionCommand();
//            case "/":
//                return new DivisionCommand();
//            case "*":
//                return new MultiplicationCommand();
//            case "EXP":
//                return new ExpCommand();
//            case "LOG":
//                return new LogCommand();
//            default:
//                throw new RuntimeException("Unexpected command: " + commandName);
//        }

    }
}
