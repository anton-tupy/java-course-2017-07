package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;

/**
 * Created by WizZo on 22.07.2017.
 */
public class DefineCommand implements Command {
    @In(type = InType.CONTEXT)
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
