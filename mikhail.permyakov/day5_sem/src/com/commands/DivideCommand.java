package com.commands;


import com.CalculatorContext;
import com.Command;
import com.annotations.In;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class DivideCommand implements Command {
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
