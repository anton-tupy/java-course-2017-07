package com.company.parsers;

import java.util.List;

public class ParseResult {
    private String commandName;
    private List<String> arguments;

    public ParseResult(String commandName, List<String> arguments) {
        this.commandName = commandName;
        this.arguments = arguments;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
