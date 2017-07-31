package com.company;

import com.company.commands.*;

/**
 * Created by Natalya on 20.07.2017.
 */
public class CommandFactory {
    public Command createCommand(String commandName){
        switch (commandName.toUpperCase()){             //uppercase если ввел маленькими то вернет Большими
            case "PUSH":
                return new PushCommand();
            case "PRINT":
                return new PrintCommand();
            case "SQRT":
                return new SqrtCommand();
            case "POP":
                return new PopCommand();
            case "DEFINE":
                return new DefineCommand();
            case "PLUS":
            case "+":
                return new PlusCommand();
            case "MINUS":
                return new MinusCommand();
            case "DIVISION":
                return new DivisionCommand();
            case "MULTI" :
                return new MultiplyCommand();
            default:
                throw new RuntimeException("unexpected command"+ commandName);
        }
    }
}
