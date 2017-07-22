package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by mitro on 22.07.17.
 */
public class DefineCommand implements Command
{
    @Override
    public void execute(List<String> arguments, CalculatorContext context)
    {
        if (arguments.size() < 2)
        {
            throw new RuntimeException();
        }
        String name = arguments.get(0);
        String valueStr = arguments.get(1);
        float value = Float.parseFloat(valueStr);
        context.defineValue(name,value);
    }
}


