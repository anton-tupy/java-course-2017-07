package com.company;

import com.company.commands.*;

/**
 * Created by mitro on 20.07.17.
 */
public class CommandFactory
{
    public Command createCommand(String commandName)
    {
        switch (commandName.toUpperCase())
        {
            case "PUSH":
                return new PushCommand();
            case "POP":
                return new PopCommand();
            case "PRINT":
                return new PrintCommand();
            case "+":
            case "PLUS":
                return new AddCommand();
            case "-":
            case "MINUS":
                return new SubtractCommand();
            case "*":
            case "MULTIPLY":
                return new MultiplyCommand();
            case "/":
            case "DIVIDE"
                return new DivideCommand();
            case "SQRT":
                return new SqrtCommand();
            case "DEFINE":
                return new DefineCommand();
            default:
                throw new RuntimeException("Unexpected command: " + commandName);
        }
    }
}
