package com.commands;


import com.CalculatorContext;
import com.Command;
import com.annotations.In;

import java.util.List;

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
