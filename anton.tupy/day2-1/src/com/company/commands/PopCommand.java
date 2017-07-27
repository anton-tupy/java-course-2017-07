package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

/**
 * Created by IT-Academy on 20.07.2017.
 */
public class PopCommand implements Command {

    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float value = context.pop();
        if (!arguments.isEmpty()) {
            String name = arguments.get(0);
            context.defineValue(name, value);
        }
    }
}
