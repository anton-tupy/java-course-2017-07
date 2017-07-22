package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PushCommand implements Command {
    @Override
    public void execute(List<String> arguments, CalculatorContext context) {
        if (arguments.isEmpty()) {
            throw new RuntimeException("PushCommand: No arguments");
        }
        String arg = arguments.get(0);
        float value;
        try {
            value = Float.parseFloat(arg);
        }catch(Exception e)
        {
          value = context.getValue(arg);
        }

        context.push(value);
    }
}
