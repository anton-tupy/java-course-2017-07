package com.company;

import java.util.List;

/**
 * Created by Natalya on 20.07.2017.
 */

        // этот класс это результат разбора строки( по заданию каждая строка состоит из имени и аргумента)
public class ParseResult {
    private String commandName;
    private List<String> arguments;

    public ParseResult(String commandName, List<String> arguments) {     //конструктор для самого класса и геттеры и сеттеры для аргументов
        this.commandName = commandName;
        this.arguments = arguments;
    }

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
