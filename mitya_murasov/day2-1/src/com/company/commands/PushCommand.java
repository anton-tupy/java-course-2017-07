package com.company.commands;

import com.company.CalculatorContext;
import com.company.CalculatorStack;
import com.company.Command;
import com.company.annotations.In;
import com.company.annotations.InType;

import java.util.List;


/**
 * Created by mitro on 20.07.17.
 */
public class PushCommand implements Command
{
    @In (type = InType.CONTEXT)
    private CalculatorContext context;

    @In (type = InType.STACK)
    private CalculatorStack stack;
    @Override
    public void execute(List<String> arguments)
    {
        if (arguments.isEmpty())
        {
            throw new RuntimeException("PushCommand: no arguments");
        }
        String arg = arguments.get(0);
        float value ;
        if (context.isValue(arg))
        {
            value = context.getValue(arg);
        }
        else
        {
            value = Float.parseFloat(arg);
        }

        stack.push(value);
    }
}
