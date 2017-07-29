package com.company;


import java.util.List;

public class ParseResauit {
    private String comandName;
    private List<String> arguments;

    public ParseResauit(String comandName, List<String> arguments) {
        this.comandName = comandName;
        this.arguments = arguments;
    }

    public String getComandName() {

        return comandName;
    }

    public void setComandName(String comandName) {
        this.comandName = comandName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
