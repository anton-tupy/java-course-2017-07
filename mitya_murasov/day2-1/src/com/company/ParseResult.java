package com.company;

import java.util.List;

/**
 * Created by mitro on 20.07.17.
 */
public class ParseResult
{
    private String commandName;
    private List<String> arguments;

    public ParseResult(String commandName, List<String> arguments)
    {
        this.commandName = commandName;
        this.arguments = arguments;
    }

    public String getCommandName()
    {
        return commandName;
    }

    public void setCommandName(String commandName)
    {
        this.commandName = commandName;
    }

    public List<String> getArguments()
    {
        return arguments;
    }
}
