package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.anotation.In;

import java.util.List;

/**
 * Created by konsz on 27.07.2017.
 */
public class LogCommands implements Command {
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float lastValue = context.pop();
        context.push((float)Math.log(lastValue));
    }
}
