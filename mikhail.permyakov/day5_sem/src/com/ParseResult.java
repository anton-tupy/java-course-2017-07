package com;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class ParseResult {

    public ParseResult(String commandName, List<String> arguments) {
        this.commandName = commandName;
        this.arguments = arguments;
    }

    private String commandName;
    private List<String> arguments;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
