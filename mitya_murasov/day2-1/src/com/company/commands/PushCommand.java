package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;

import java.util.List;


/**
 * Created by mitro on 20.07.17.
 */
public class PushCommand implements Command
{
    @Override
    public void execute(List<String> arguments, CalculatorContext context)
    {
        if (arguments.isEmpty())
        {
            throw new RuntimeException("PushCommand: no arguments");
        }
        String arg = arguments.get(0);
        float value = Float.parseFloat(arg);


        context.push(value);
    }
}
