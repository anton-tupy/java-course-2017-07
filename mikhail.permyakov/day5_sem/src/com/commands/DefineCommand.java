package com.commands;


import com.CalculatorContext;
import com.CalculatorStack;
import com.Command;
import com.annotations.In;
import com.annotations.InType;

import java.util.List;

/**
 * Created by It-Academy-5 on 22.07.2017.
 */
public class DefineCommand implements Command {
    @In (type = InType.CONTEXT)
    private CalculatorContext context;

    @Override
    public void execute(List<String> arguments) {
        if (arguments.size() < 2) {
            throw new RuntimeException("DefineCommand: too few arguments");
        }
        String name = arguments.get(0);
        String valueStr = arguments.get(1);
        float value = Float.parseFloat(valueStr);
        context.defineValue(name, value);
    }
}
