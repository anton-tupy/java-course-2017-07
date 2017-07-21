package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

public class PrintCommand implements Command {

    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        float value = context.peek();
        System.out.println(value);
    }
}
