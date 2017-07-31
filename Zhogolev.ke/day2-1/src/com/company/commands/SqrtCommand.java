package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.anotation.In;

import java.util.List;

import static java.lang.System.in;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class SqrtCommand implements Command {
    @In
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        float value = context.pop();
        float result = (float)Math.sqrt(value);
        context.push(result);
    }
}
