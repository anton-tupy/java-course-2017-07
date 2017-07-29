package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PushCommand implements Command {

    @In
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

        context.push(value);
    }
}
