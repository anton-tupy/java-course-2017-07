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
            case "PRINT":
                return new PrintCommand();
            case "DEFINE":
                return  new DefineCommand();
            case "SQRT":
                return new SqrtCommand();
            case "+":
                return new AddCommand();
            case "-":
                return new SumCommand();
            case "*":
                return new MultiplicationCommand();
            case "/":
                return new DerCommand();
            case "#":
                return new CommentCommand();
            default:
                throw new RuntimeException("Unexpected command: " + commandName);
        }
    }
}
