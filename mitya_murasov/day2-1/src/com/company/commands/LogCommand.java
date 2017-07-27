package com.company.commands;

import com.company.CalculatorContext;
import com.company.Command;
import com.company.annotations.In;

import java.util.List;

/**
 * Created by mitro on 27.07.17.
 */
public class LogCommand implements Command
{
    @In
    private CalculatorContext context;
    @Override
    public void execute(List<String> arguments)
    {
        float value1 = context.pop();
        float result = (float)Math.log(value1);
        context.push(result);
    }
}
