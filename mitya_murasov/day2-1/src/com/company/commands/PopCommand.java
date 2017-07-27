package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;

/**
 * Created by mitro on 22.07.17.
 */
public class PopCommand implements Command
{
    @Override
    public void execute(List<String> arguments, CalculatorContext context)
    {
        float value = context.pop();
        if (!arguments.isEmpty())
        {
            String name = arguments.get(0);
            context.defineValue(name,value);
        }
    }
}
