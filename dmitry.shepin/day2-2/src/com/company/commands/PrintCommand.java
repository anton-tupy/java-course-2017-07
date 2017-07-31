package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

public class PrintCommand implements Command {
    @In
    private CalculatorContext context;


    @Override
    public void execute(List<String> arguments) {
        float value = context.peek();
        System.out.println(value);
    }
}
