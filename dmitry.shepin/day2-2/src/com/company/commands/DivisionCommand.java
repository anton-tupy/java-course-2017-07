package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

public class DivisionCommand implements Command {
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float value1 = context.pop();
        float value2 = context.pop();
        float result = value2 / value1;
        context.push(result);
    }
}





