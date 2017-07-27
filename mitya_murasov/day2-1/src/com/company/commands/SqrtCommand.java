package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

/**
 * Created by mitro on 22.07.17.
 */
public class SqrtCommand implements Command
{
    @In
    private CalculatorContext context;
    @Override
    public void execute(List<String> arguments)
    {
        float value = context.pop();
        double result = Math.sqrt(value);
        context.push(value);
    }
}
