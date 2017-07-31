package com.company;

import com.company.commands.*;

public class CommandFactory {
    public Command createCommand(String commandName) {
        switch (commandName.toUpperCase()) {
            case "PUSH":
                return new PushCommand();
            case "PRINT":
                return new PrintCommand();
            case "POP":
                return new PopCommand();
            case "SQRT":
                return new SqrtCommand();
            case "+":
                return new AdditionCommand();
            case "-":
                return new SubtractionCommand();
            case "/":
                return new DivisionCommand();
            case "*":
                return new MultiplicationCommand();
            default:
                throw new RuntimeException("Unexpected command: " + commandName);
        }
    }
}
