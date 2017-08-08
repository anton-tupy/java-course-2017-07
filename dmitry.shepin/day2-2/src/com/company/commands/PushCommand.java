package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

public class PushCommand implements Command {

    @In(type = InType.STACK)
    private CalculatorStack stack;

    @In(type = InType.CONTEXT)
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        if (arguments.isEmpty()) {
            throw new RuntimeException("PushCommand: No arguments");
        }

        String arg = arguments.get(0);

        float value;
        if (context.isValue(arg)) {
            value = context.getValue(arg);
        }
        else {
            value = Float.parseFloat(arg);
        }

        stack.push(value);
    }
}
