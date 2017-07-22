package com.company;

import com.company.commands.*;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class CommandFactory {
    public Command createCommand(String commandName) {
        switch (commandName.toUpperCase()) {
            case "PUSH":
                return new PushCommand();
            case "POP":
                return new PopCommand();
            case "DEFINE":
                return new DefineCommand();
            case "PRINT":
                return new PrintCommand();
            case "+":
            case "PLUS":
                return new AddCommand();
            case "-":
            case "MINUS":
                return new SubtractCommand();
            case "/":
            case "DIVISION":
                return new DivideCommand();
            case "*":
            case "MULTI":
                return new MultiplyCommand();
            case "SQRT":
                return new SqrtCommand();
            default:
                throw new RuntimeException("Unexpected command: " + commandName);
        }
    }
}
