package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

public class PopCommand implements Command {
    @In(type = InType.STACK)
    private CalculatorStack stack;

    @In(type = InType.CONTEXT)
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float value = stack.pop();
        if (!arguments.isEmpty()) {
            String name = arguments.get(0);
            context.defineValue(name, value);
        }
    }
}
