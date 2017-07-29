package com.commands;


import com.CalculatorContext;
import com.CalculatorStack;
import com.Command;
import com.annotations.In;
import com.annotations.InType;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PushCommand implements Command {
    @In (type = InType.STACK)
    private CalculatorStack stack;

    @In (type = InType.CONTEXT)
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
