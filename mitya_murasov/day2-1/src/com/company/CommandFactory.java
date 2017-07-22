package com.company;

import com.company.commands.PrintCommand;
import com.company.commands.PushCommand;

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
            case "PRINT":
                return new PrintCommand();
            default:
                throw new RuntimeException("Unexpected command: " + commandName);
        }
    }
}
